package Q349;

import java.util.*;

/**
 * 时间复杂度为n(logn)^2
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums1) {
        	set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
        	if (set.contains(num)) {
        		list.add(num);
        		set.remove(num);
        	}
        }

        int listSize = list.size();
        int[] arr = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
