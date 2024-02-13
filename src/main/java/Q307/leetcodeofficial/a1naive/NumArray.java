package Q307.leetcodeofficial.a1naive;

public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
    }

    /**
     * O(1)
     */
    public void update(int i, int val) {
        nums[i] = val;
    }

    /**
     * O(n)
     */
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int index = i; index <= j; ++index) {
            sum += nums[index];
        }
        return sum;
    }
}
