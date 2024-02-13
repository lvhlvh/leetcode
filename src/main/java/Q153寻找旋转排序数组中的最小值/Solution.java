package Q153寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)  return -1;
        // 数组是否已经有序
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid;
        }

        return Math.min(nums[l], nums[r]);
    }
}