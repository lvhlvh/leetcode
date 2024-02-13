package jianzhioffer.Q31连续子数组的最大和;

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < n; ++i) {
      dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
      if (dp[i] > max) {
        max = dp[i];
      }
    }

    return max;
  }
}
