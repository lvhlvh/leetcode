package Q300最长上升子序列;

import java.util.Arrays;

/**
 * 动态规划 (自底向上)
 *
 * <p>了解了递归解法的思路后, 动态规划解法的状态公式不难得出:
 *
 * <p>dp[i] 用于记录以 nums[i] 结尾的LIS, dp[i] = max(dp[i], dp[j] + 1), j = 0,...,i-1
 */
public class Solution2 {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    // dp[i]: 以nums[i]结尾的最长递增子序列的长度
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1); // 以nums[i]结尾的LIS至少包含自己

    for (int i = 1; i < nums.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    return max(dp);
  }

  private int max(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max) max = num;
    }
    return max;
  }
}
