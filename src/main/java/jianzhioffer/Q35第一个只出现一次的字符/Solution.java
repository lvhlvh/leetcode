package jianzhioffer.Q35第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
  public char firstUniqChar(String s) {
    if (s == null || s.length() == 0) return ' ';

    Map<Character, Integer> map = new LinkedHashMap<>();
    char[] chars = s.toCharArray();
    for (char ch : chars) {
      map.merge(ch, 1, Integer::sum);
    }

    for (Character ch : map.keySet()) {
      if (map.get(ch) == 1) {
        return ch;
      }
    }

    return ' ';
  }
}
