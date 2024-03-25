package systemdesign.ratelimiter;

public interface PerClientRateLimiter {
  boolean isAllowed(String clientId);
}
