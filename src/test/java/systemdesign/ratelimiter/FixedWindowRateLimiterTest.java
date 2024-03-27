package systemdesign.ratelimiter;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FixedWindowRateLimiterTest {

  @Test
  void test() throws InterruptedException {
    RateLimiter rateLimiter = new FixedWindowRateLimiter(10);

    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100; i++) {
      TimeUnit.MILLISECONDS.sleep(20L);
      threadPool.execute(rateLimiter::isAllowed);
    }
    threadPool.awaitTermination(5L, TimeUnit.SECONDS);
  }
}
