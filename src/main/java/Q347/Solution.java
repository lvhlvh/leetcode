package Q347;

import java.util.*;

public class Solution {
    private class Freq implements Comparable<Freq> {
        public Integer elem;
        public Integer freq;

        public Freq(Integer elem, Integer freq) {
            this.elem = elem;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq freq) {
            if (this.freq < freq.freq) // 小的排在优先队列的前面（即底层是小顶堆）
                return -1;
            else if (this.freq > freq.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 1;
        // Java内置的PriorityQueue默认根据泛型参数Freq类(实现了Comparable接口)的compareTo方法的逻辑对元素进行排序
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (count <= k) {
                pq.add(new Freq(key, map.get(key)));
            } else {
                if (pq.peek().freq < map.get(key)) {
                    pq.poll();
                    pq.add(new Freq(key, map.get(key)));
                }
            }
            count++;
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().elem);
        }

        return list;
    }
}
