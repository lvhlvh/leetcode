package Q503下一个更大元素II;

import java.util.Stack;

public class Solution {
  /*
   * 因为顶多转一圈就找到目标了，因此我们可以把原数组重复两份，然后套用单调栈模板
   * 1,2,1 -> 1,2,1,1,2,1 然后用单调栈处理这个长度为6的数组
   * 其实，我们甚至都没必要真正开辟一个长度为6的数组，只需要模拟一下就行了，还使用
   *   那个长度为3的数组
   */
  public int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];

    Stack<Integer> s = new Stack<>();
    for (int i = 2 * nums.length - 1; i >= 0; --i) {
      while (!s.isEmpty() && nums[i % nums.length] >= s.peek()) s.pop();

      // 在右半部分没找到(-1)也没关系，在左半部分还会再找一遍
      result[i % nums.length] = s.isEmpty() ? -1 : s.peek();
      s.push(nums[i % nums.length]);
    }

    return result;
  }
}
