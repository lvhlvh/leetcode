package systemdesign.ratelimiter;

public abstract class RateLimiter {

  protected final int maxRequestPerSec;

  public RateLimiter(int maxRequestPerSec) {
    this.maxRequestPerSec = maxRequestPerSec;
  }

  protected abstract boolean isAllowed();
}
