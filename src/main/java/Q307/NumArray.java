package Q307;

public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        int numsLen = nums.length;
        for (int i = 1; i < numsLen; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        int oldI;
        if (i == 0) { // 边界
            oldI = nums[0];
        } else {
            oldI = nums[i] - nums[i-1];
        }
        int diff = val - oldI;

        int numsLen = this.nums.length;
        for (int k = i; k< numsLen; ++k) {
            nums[k] += diff;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return nums[j];
        return nums[j] - nums[i - 1];
    }
}