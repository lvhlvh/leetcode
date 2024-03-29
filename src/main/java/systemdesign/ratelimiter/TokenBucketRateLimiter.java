package systemdesign.ratelimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketRateLimiter {
  private final long maxBucketSize;

  /** 每秒允许处理的请求数 */
  private final long refillRatePerSec;

  private long currentBucketSize;

  /** 上一次填充的时间 */
  private Instant lastRefillTime;

  public TokenBucketRateLimiter(long maxBucketSize, long refillRatePerSec) {
    this.maxBucketSize = maxBucketSize;
    this.refillRatePerSec = refillRatePerSec;

    /** 初始时填满token */
    this.currentBucketSize = maxBucketSize;
    this.lastRefillTime = Instant.now();
  }

  public synchronized boolean isAllowed(long neededTokenSize) {
    // 1. 一开始先refill token
    refillToken();

    // 2. 判断token数量是否足够
    if (currentBucketSize >= neededTokenSize) {
      currentBucketSize -= neededTokenSize;
      return true;
    }

    return false;
  }

  private void refillToken() {
    Instant now = Instant.now();
    long elapsedTimeSinceLastRefill = Duration.between(lastRefillTime, now).toMillis();
    long tokensToAdd = (long) ((elapsedTimeSinceLastRefill * 1.0 / 1000) * refillRatePerSec);

    currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
    lastRefillTime = now;
  }
}
