package systemdesign.ratelimiter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FixedWindowRateLimiter extends RateLimiter {

  private Window currentWindow;

  public FixedWindowRateLimiter(int maxRequestPerSec) {
    super(maxRequestPerSec);
  }

  @Override
  public synchronized boolean isAllowed() {
    Instant now = Instant.now();

    if (currentWindow == null || now.isAfter(currentWindow.getStartSec().plusSeconds(1L))) {
      currentWindow = new Window(now.truncatedTo(ChronoUnit.SECONDS));
      log.info("当前时间={}: 新建窗口={}", now, currentWindow);
    }

    if (currentWindow.hasRequestCountReachedLimit(maxRequestPerSec)) {
      log.info("当前时间={}: 窗口={}, ❌‍️", now, currentWindow);
      return false;
    }

    log.info("当前时间={}: 窗口={}, ✅", now, currentWindow);
    currentWindow.incrRequestCount();
    return true;
  }

  @ToString
  private static class Window {
    /** 窗口开始时间必须是整秒, 窗口长度为1秒 */
    @Getter private final Instant startSec;

    @Getter @Setter private int requestCount;

    public Window(Instant startSec) {
      Preconditions.checkArgument(startSec.getNano() == 0, "窗口开始时间不是整秒");
      this.startSec = startSec;
      this.requestCount = 0;
    }

    public boolean hasRequestCountReachedLimit(int limit) {
      return this.requestCount >= limit;
    }

    public void incrRequestCount() {
      this.requestCount += 1;
    }
  }
}
