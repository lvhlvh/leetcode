package systemdesign.ratelimiter;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@Slf4j
public class SlidingWindowRateLimiter implements RateLimiter {

  /** 窗口允许的最大请求数 */
  private final int maxRequestPerWindow;

  /** 窗口大小 */
  private final Duration windowSize;

  // 注意: 这里只需要普通队列即可, 因为java中没有普通队列, 所以使用Deque
  private final ConcurrentHashMap<String, Deque<Instant>> clientHistoryVisitTimesMap =
      new ConcurrentHashMap<>();

  public SlidingWindowRateLimiter(int maxRequestPerWindow, Duration windowSize) {
    this.maxRequestPerWindow = maxRequestPerWindow;
    this.windowSize = windowSize;
  }

  @Override
  public synchronized boolean isAllowed(String clientId) {
    Deque<Instant> clientHistoryVisitTimes =
        clientHistoryVisitTimesMap.computeIfAbsent(clientId, k -> new ConcurrentLinkedDeque<>());

    Instant now = Instant.now();
    // 以当前时间作为滑动窗口的右端点, 当前时间-windowSize作为滑动窗口的左端点, 用户最早的访问时间在滑动窗口之前时, 需要将其清除出历史访问记录,
    // 从而得到当前滑动窗口内的访问次数
    while (!clientHistoryVisitTimes.isEmpty()
        && clientHistoryVisitTimes.peekFirst().isBefore(now.minus(windowSize))) {
      Instant removedClientHistoryVisitTimes = clientHistoryVisitTimes.pollFirst();
      log.info(
          "客户端={}, 当前滑动窗口={}至{}: 移除访问记录 {}, 窗口内访问次数 {}",
          clientId,
          LocalDateTime.ofInstant(now.minus(windowSize), ZoneId.systemDefault()),
          LocalDateTime.ofInstant(now, ZoneId.systemDefault()),
          LocalDateTime.ofInstant(removedClientHistoryVisitTimes, ZoneId.systemDefault()),
          clientHistoryVisitTimes.size());
    }

    if (clientHistoryVisitTimes.size() < maxRequestPerWindow) {
      log.info(
          "客户端={}, 当前滑动窗口={}至{}, 窗口内访问次数={}: 接收请求",
          clientId,
          LocalDateTime.ofInstant(now.minus(windowSize), ZoneId.systemDefault()),
          LocalDateTime.ofInstant(now, ZoneId.systemDefault()),
          clientHistoryVisitTimes.size());
      clientHistoryVisitTimes.addLast(now);
      return true;
    }

    log.info(
        "客户端={}, 当前滑动窗口={}至{}, 窗口内访问次数={}: 拒绝请求",
        clientId,
        LocalDateTime.ofInstant(now.minus(windowSize), ZoneId.systemDefault()),
        LocalDateTime.ofInstant(now, ZoneId.systemDefault()),
        clientHistoryVisitTimes.size());
    return false;
  }
}
