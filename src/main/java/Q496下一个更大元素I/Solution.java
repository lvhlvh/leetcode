package Q496下一个更大元素I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** 设nums1长度为M, nums2长度为N 时间复杂度: O(N) 空间复杂度: O(M+N), map + stack */
public class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // 存放(元素值, 第一个比该元素大的值)的映射
    Map<Integer, Integer> map = new HashMap<>();

    // 单调减栈
    Stack<Integer> s = new Stack<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && nums2[i] >= s.peek()) s.pop();

      if (s.isEmpty()) map.put(nums2[i], -1);
      else map.put(nums2[i], s.peek());

      s.push(nums2[i]);
    }

    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; ++i) {
      result[i] = map.get(nums1[i]);
    }

    return result;
  }
}
