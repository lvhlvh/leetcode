package Q303;

/** 存储: O(n) 直接把和存起来 查询: O(1) */
class NumArray2 {
  private int[] nums;

  public NumArray2(int[] nums) {
    int numsLen = nums.length;
    for (int i = 1; i < numsLen; i++) {
      nums[i] += nums[i - 1];
    }
    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    if (i == 0) return nums[j];
    return nums[j] - nums[i - 1];
  }

  public static void main(String[] args) {
    int[] arr = {-2, 0, 3, -5, 2, -1};
    NumArray2 numArray2 = new NumArray2(arr);
    System.out.println(numArray2.sumRange(0, 2));
    System.out.println(numArray2.sumRange(2, 5));
    System.out.println(numArray2.sumRange(0, 5));
  }
}
