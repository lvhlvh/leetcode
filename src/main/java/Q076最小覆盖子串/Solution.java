package Q076最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public String minWindow(String s, String t) {
    // 存放窗口内的字符
    Map<Character, Integer> window = new HashMap<>();
    // 存放待找的字符 (t): 可重复, 比如t里面有两个a，那么窗口里面也必须有两个a
    Map<Character, Integer> need = new HashMap<>();

    for (int i = 0; i < t.length(); ++i) {
      char ch = t.charAt(i);
      need.put(ch, need.getOrDefault(ch, 0) + 1);
    }

    int left = 0, right = 0;
    int satisfied = 0; // 当前窗口内已经符合条件的字符数
    // 返回最短子串: start + len 可以确定一个子串
    int start = 0, len = Integer.MAX_VALUE;

    while (right < s.length()) {
      char c = s.charAt(right++);
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c) == need.get(c)) satisfied++;
      }

      // when to shrink
      while (satisfied == need.size()) {
        if (right - left < len) {
          start = left;
          len = right - left;
        }

        char d = s.charAt(left++);
        if (need.containsKey(d)) {
          if (window.get(d) == need.get(d)) satisfied--;
          window.put(d, window.get(d) - 1);
        }
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
}
