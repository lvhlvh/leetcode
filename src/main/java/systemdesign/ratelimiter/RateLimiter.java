package systemdesign.ratelimiter;

public interface RateLimiter {
  boolean isAllowed(String clientId);
}
