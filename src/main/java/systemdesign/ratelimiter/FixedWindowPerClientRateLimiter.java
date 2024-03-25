package systemdesign.ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://www.codereliant.io/rate-limiting-deep-dive/">Slow Down! Rate Limiting Deep
 * Dive</a>
 */
@Slf4j
public class FixedWindowPerClientRateLimiter implements PerClientRateLimiter {

  /** 每个窗口允许的最大请求数 */
  private final int maxRequestPerWindow;

  /** 窗口大小 */
  private final Duration windowSize;

  /** key: 客户端id, value: 该客户端对应的窗口 */
  private final Map<String, Window> clientWindowMap = new HashMap<>();

  public FixedWindowPerClientRateLimiter(int maxRequestPerWindow, Duration windowSize) {
    this.maxRequestPerWindow = maxRequestPerWindow;
    this.windowSize = windowSize;
  }

  @Override
  public synchronized boolean isAllowed(String clientId) {
    Instant now = Instant.now();
    Window window = clientWindowMap.get(clientId);

    // 客户端尚未请求过, 则新建一个窗口
    // 当前时间已经过了上一个窗口期, 则新建一个窗口
    if (window == null || now.isAfter(window.getStartTime().plus(windowSize))) {
      window = new Window(now, windowSize, 0);
      clientWindowMap.put(clientId, window);
      log.info(
          "客户端={}, 请求时间={}: 创建新窗口, 窗口范围={}至{}",
          clientId,
          LocalDateTime.ofInstant(now, ZoneId.systemDefault()),
          LocalDateTime.ofInstant(window.getStartTime(), ZoneId.systemDefault()),
          LocalDateTime.ofInstant(window.getEndTime(), ZoneId.systemDefault()));
    }

    // 如果客户端当前窗口的请求数量已达上限, 则限流
    if (window.getRequestCount() >= maxRequestPerWindow) {
      log.info(
          "客户端={}, 请求时间={}, 窗口范围={}至{}: 拒绝请求",
          clientId,
          LocalDateTime.ofInstant(now, ZoneId.systemDefault()),
          LocalDateTime.ofInstant(window.getStartTime(), ZoneId.systemDefault()),
          LocalDateTime.ofInstant(window.getEndTime(), ZoneId.systemDefault()));
      return false;
    }

    // 如果客户端当前窗口的请求数量未达上线, 则不限流
    log.info(
        "客户端={}, 请求时间={}, 窗口范围={}至{}: 接收请求",
        clientId,
        LocalDateTime.ofInstant(now, ZoneId.systemDefault()),
        LocalDateTime.ofInstant(window.getStartTime(), ZoneId.systemDefault()),
        LocalDateTime.ofInstant(window.getEndTime(), ZoneId.systemDefault()));
    window.setRequestCount(window.getRequestCount() + 1);
    return false;
  }

  @AllArgsConstructor
  private static class Window {
    /** 窗口的开始时间 */
    @Getter private final Instant startTime;

    /** 窗口大小 */
    @Getter private final Duration windowSize;

    /** 当前窗口内的请求数量 */
    @Getter @Setter private int requestCount;

    public Instant getEndTime() {
      return this.startTime.plus(windowSize);
    }
  }
}
