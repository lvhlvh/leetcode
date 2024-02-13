package Q026删除排序数组中的重复项;

/**
 * 条件是 nums[j] != nums[j - 1] 时的分析:
 *
 * <p>- 如果数组中不存在重复元素, 则i,j始终保持一致, OK - 如果数组中存在重复元素，则j - i >= 1, 还是OK
 */
public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return 1;

    int i, j;
    i = j = 1;
    for (; j < nums.length; ++j) {
      if (nums[j] != nums[i - 1]) // 条件也可以是nums[j] != nums[j - 1]
      nums[i++] = nums[j];
    }

    return i;
  }
}
