package Q303;

/** 存储: O(1) 查询: O(n) */
class NumArray {
  private int[] nums;

  public NumArray(int[] nums) {
    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum += nums[k];
    }
    return sum;
  }
}
