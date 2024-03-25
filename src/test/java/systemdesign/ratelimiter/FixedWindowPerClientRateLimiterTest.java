package systemdesign.ratelimiter;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class FixedWindowPerClientRateLimiterTest {

  @Test
  public void test() throws InterruptedException {
    PerClientRateLimiter rateLimiter = new FixedWindowPerClientRateLimiter(10, Duration.ofSeconds(1L));

    final String clientId = "1";
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100; i++) {
      threadPool.submit(() -> rateLimiter.isAllowed(clientId));
    }
    threadPool.awaitTermination(3L, TimeUnit.SECONDS);
  }
}
