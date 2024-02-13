package Q027RemoveElement;

public class Solution {
  public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; ++j) { // j一定>=i
      if (nums[j] != val) {
        nums[i++] = nums[j];
      }
    }
    return i;
  }
}
