package Q739每日温度;

import java.util.Stack;

public class Solution {
  public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    Stack<Integer> s = new Stack<>();

    for (int i = T.length - 1; i >= 0; --i) {
      while (!s.isEmpty() && T[i] >= T[s.peek()]) s.pop();

      result[i] = s.isEmpty() ? 0 : (s.peek() - i);
      s.push(i);
    }

    return result;
  }
}
