package Q283MoveZero;

/** 基于swap的优化, 减少swap次数 */
public class Solution3 {
  public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) {
        if (i != j) {
          int tmp = nums[j];
          nums[j] = nums[i];
          nums[i] = tmp;
        }
        j++;
      }
    }
  }
}
