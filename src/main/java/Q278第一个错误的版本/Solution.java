package Q278第一个错误的版本;

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    if (n == 0) return -1;

    int l = 1, r = n;
    while (l + 1 < r) {
      int mid = l + ((r - l) >>> 1);
      if (isBadVersion(mid)) r = mid;
      else l = mid + 1;
    }

    if (isBadVersion(l)) return l;
    if (isBadVersion(r)) return r;
    return -1;
  }
}
