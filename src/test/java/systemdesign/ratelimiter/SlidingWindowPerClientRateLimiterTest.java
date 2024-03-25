package systemdesign.ratelimiter;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SlidingWindowPerClientRateLimiterTest {

  @Test
  void isAllowed() throws InterruptedException {
    // 需求: 实现10QPS的限流, 且确保用户1s内的请求被均匀的接收 (因为该方案的滑动窗口依赖于用户的访问时间, 而不是真正的每100ms移动一次窗口, 所以难以严格的实现10QPS)
    PerClientRateLimiter rateLimiter = new SlidingWindowPerClientRateLimiter(1, Duration.ofMillis(100L));

    final String clientId = "1";
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100; i++) {
      TimeUnit.MILLISECONDS.sleep(10L);
      threadPool.submit(() -> rateLimiter.isAllowed(clientId));
    }
    threadPool.awaitTermination(3L, TimeUnit.SECONDS);
  }
}
