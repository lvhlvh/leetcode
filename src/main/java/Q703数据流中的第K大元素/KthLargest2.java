package Q703数据流中的第K大元素;

import java.util.PriorityQueue;

/**
 * Better Solution!!! KthLargest()可以调用add()啊!!!
 */
public class KthLargest2 {
    private PriorityQueue<Integer> minHeap;
    private int limit;

    public KthLargest2(int k, int[] nums) {
        limit = k;
        minHeap = new PriorityQueue<>(limit);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < limit) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}
