package Q347;

import java.util.*;

/**
 * 不借助自定义Freq类
 */
public class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));
        for (Integer key : map.keySet()) {
            if (count <= k) {
                pq.add(key);
            } else {
                if (map.get(pq.peek()) < map.get(key)) {
                    pq.poll();
                    pq.add(key);
                }
            }
            count++;
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        return list;
    }

}
