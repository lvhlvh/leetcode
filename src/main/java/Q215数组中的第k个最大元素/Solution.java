package Q215数组中的第k个最大元素;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * <p>利用快速选择算法，该算法和快排的思想一样，因此可以套用快排模板。
 *
 * <p>原问题可以转化为【求第x小的数】 (x = nums.length + 1 - k)
 *
 * <p>每轮快速选取一个pivot, 每轮排序的结果是: 得到一个分界点j, 使得[l, j]区间内的元素都小于等于pivot; [j + 1, r]区间内的元素都大于等于pivot。[l,
 * j]区间内有 j - l + 1个元素,
 *
 * <ul>
 *   <li>如果x <= j - l + 1, 说明第x小的数在左区间[l, j]中, 可以递归在左区间内寻找第x小的数;
 *   <li>如果x >= j - l + 1, 说明第x小的数在右区间[j + 1, r]中，可以递归在右区间内寻找第x - (j - l + 1)小的数
 * </ul>
 *
 * 可以看到，我们每次缩小区间，都确保了【第x小的数】就在我们缩小后的区间内，因此，最后当区间长度为1时，就是我们要找的答案。
 *
 * <p>应当留意两个重要的结论:
 *
 * <ul>
 *   <li>下面代码(1)处: l 一定小于等于 r, 不可能出现l > r
 *   <li>下面代码(2)处: 一定有i == j, 或者 i - 1 == j
 * </ul>
 */
public class Solution {
  private static final Random random = new Random();

  public int findKthLargest(int[] nums, int k) {
    // 第k大等价于第n + 1 - k小
    return quickSelect(nums, 0, nums.length - 1, nums.length + 1 - k);
  }

  /** 寻找数组nums中第kk小的元素 快速选择过程中，始终保持答案在我们选择的区间中，因此最后区间长度为1时，就是我们要找的答案 */
  private int quickSelect(int[] nums, int l, int r, int kk) {
    if (l == r) return nums[l]; // (1)

    int pivot = nums[l + random.nextInt(r - l)];
    int i = l - 1, j = r + 1;
    while (i < j) {
      while (nums[++i] < pivot)
        ;
      while (nums[--j] > pivot)
        ;
      if (i < j) swap(nums, i, j);
    }
    // (2)
    int leftCount = j - l + 1;
    if (kk <= leftCount) return quickSelect(nums, l, j, kk);
    else return quickSelect(nums, j + 1, r, kk - leftCount);
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}
