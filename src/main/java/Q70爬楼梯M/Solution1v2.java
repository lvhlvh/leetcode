package Q70爬楼梯M;

/**
 * 以空间换时间, 增加一个数组用于存储计算过的f(n), 从而使得时间复杂度降低为O(n): 因为对于1...n的每个f(i)只需要计算一次
 */
public class Solution1v2 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs0(n, memo);
    }

    private int climbStairs0(int n, int[] memo) {
        // f(1) = 1, f(2) = 2
        if (n <= 2) {
            return n;
        }

        // if f(n) was already saved
        if (memo[n] > 0) {
            return memo[n];
        }

        // if f(n) hasn't saved
        memo[n] = climbStairs0(n - 1, memo) + climbStairs0(n - 2, memo);
        return memo[n];
    }
}
