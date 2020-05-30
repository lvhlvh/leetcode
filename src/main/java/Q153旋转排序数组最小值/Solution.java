package Q153旋转排序数组最小值;

public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        if (nums[l] <= nums[r]) return nums[l]; // 有序
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == 0) {
                l = mid + 1;
                continue;
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[0]) {
                r = mid - 1;
            } else if (nums[mid] > nums[0]) {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];

        int start = 0, end = nums.length - 1;
        int lastNum = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= lastNum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start] <= lastNum ? nums[start] : nums[end];
    }

    public int findMin3(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;
        int lastNum = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= lastNum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start] <= lastNum ? nums[start] : nums[end];
    }
}