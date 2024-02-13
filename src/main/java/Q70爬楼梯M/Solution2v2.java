package Q70爬楼梯M;

/** 对Solution2进行了空间性能上的优化 */
public class Solution2v2 {
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int x = 1;
    int y = 2;
    int z = 0;
    for (int i = 3; i <= n; i++) {
      z = x + y;
      x = y;
      y = z;
    }
    return z;
  }
}
