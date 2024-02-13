package Q033搜索旋转排序数组;

public class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;

    int l = 0, r = nums.length - 1;
    while (l + 1 < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > nums[0]) {
        if (target < nums[mid] && target >= nums[0]) r = mid;
        else l = mid;
      } else {
        if (target > nums[mid] && target < nums[0]) l = mid;
        else r = mid;
      }
    }

    if (nums[l] == target) return l;
    if (nums[r] == target) return r;
    return -1;
  }
}
