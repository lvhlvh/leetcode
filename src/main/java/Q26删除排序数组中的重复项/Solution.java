package Q26删除排序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int i, j;
        i = j = 1;
        for (; j < nums.length; ++j) {
            if (nums[j] != nums[j - 1]) nums[i++] = nums[j];
        }

        return i;
    }
}
