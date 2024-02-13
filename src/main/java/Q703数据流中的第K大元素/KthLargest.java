package Q703数据流中的第K大元素;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    private int maxSize = 0; // Java的优先队列支持动态扩容，因此需要用maxSize记录队列是否达到规定容量

    public KthLargest(int k, int[] nums) {
        maxSize = k;
        minHeap = new PriorityQueue<>(maxSize);

        // !!! 注意考虑k刚好比nums.length大1的特殊情况 !!!
        // maxSize 刚好比 nums.length 大1
        if (nums.length == maxSize - 1) {
            for (int num : nums) {
                minHeap.add(num);
            }
        } else { // nums.length >= maxSize
            for (int i = 0; i < maxSize; i++) {
                minHeap.add(nums[i]);
            }

            for (int i = maxSize; i < nums.length; i++) {
                if (nums[i] > minHeap.peek()) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() < maxSize) {
            minHeap.add(val);
        } else if (minHeap.size() == maxSize && val > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(val);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
        System.out.println(kthLargest.add(2));
    }
}
