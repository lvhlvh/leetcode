package Q027RemoveElement;

public class Solution2 {
  public int removeElement(int[] nums, int val) {
    int i = 0;
    int len = nums.length;
    while (i < len) {
      if (nums[i] == val) { // 如果nums[i]=val, 则相当于把nums[i]的值和最后一个元素交换，然后len--
        nums[i] = nums[len - 1];
        len--;
      } else {
        i++;
      }
    }
    return len;
  }
}
