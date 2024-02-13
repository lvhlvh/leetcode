package 面试题1718最短超串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public int[] shortestSeq(int[] big, int[] small) {
    Map<Integer, Integer> window = new HashMap<>();
    Set<Integer> need = new HashSet<>();
    for (int i = 0; i < small.length; ++i) need.add(small[i]);

    int left = 0, right = 0;
    int satisfied = 0;
    boolean hasSatisfied = false;
    int start = 0, minLen = Integer.MAX_VALUE;
    while (right < big.length) {
      int num = big[right++];

      if (need.contains(num)) {
        window.put(num, window.getOrDefault(num, 0) + 1);
        if (window.get(num) == 1) satisfied++;
      }

      if (satisfied == need.size()) {
        hasSatisfied = true;
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }

        int num2 = big[left++];

        if (need.contains(num2)) {
          if (window.get(num2) == 1) satisfied--;
          window.put(num2, window.get(num2) - 1);
        }
      }
    }

    return hasSatisfied ? new int[] {start, start + minLen - 1} : new int[] {};
  }
}
