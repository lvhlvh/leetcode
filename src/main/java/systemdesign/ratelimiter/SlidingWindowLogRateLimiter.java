package systemdesign.ratelimiter;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class SlidingWindowLogRateLimiter extends RateLimiter {

  private final Queue<Instant> visitTimeLogs = new LinkedList<>();

  private static final long WINDOW_SIZE_IN_SEC = 1L;

  public SlidingWindowLogRateLimiter(int maxRequestPerSec) {
    super(maxRequestPerSec);
  }

  @Override
  protected synchronized boolean isAllowed() {
    Instant now = Instant.now();

    while (!visitTimeLogs.isEmpty()
        && visitTimeLogs.peek().isBefore(now.minusSeconds(WINDOW_SIZE_IN_SEC))) {
      Instant removedVisitLog = visitTimeLogs.poll();
      log.info(
          "当前时间={}: 窗口=({}, {}), 删除过期记录={}",
          now,
          now.minusSeconds(WINDOW_SIZE_IN_SEC),
          now,
          removedVisitLog);
    }

    if (visitTimeLogs.size() >= maxRequestPerSec) {
      log.info(
          "当前时间={}: 窗口=({}, {}), 窗口内访问量={}, ❌",
          now,
          now.minusSeconds(WINDOW_SIZE_IN_SEC),
          now,
          visitTimeLogs.size());
      return false;
    }

    log.info(
        "当前时间={}: 窗口=({}, {}), 窗口内访问量={}, ✅",
        now,
        now.minusSeconds(WINDOW_SIZE_IN_SEC),
        now,
        visitTimeLogs.size());
    visitTimeLogs.add(now);
    return false;
  }
}
