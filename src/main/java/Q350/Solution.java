package Q350;

import java.util.*;

public class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new TreeMap<>();

    for (int num : nums1) {
      if (!map.containsKey(num)) {
        map.put(num, 1);
      } else {
        map.put(num, map.get(num) + 1);
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      if (map.containsKey(num)) {
        list.add(num);
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) map.remove(num);
      }
    }

    int listSize = list.size();
    int[] ret = new int[listSize];
    for (int i = 0; i < listSize; i++) {
      ret[i] = list.get(i);
    }

    return ret;
  }
}
