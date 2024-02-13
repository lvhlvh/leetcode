package Q480滑动窗口的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/** 引入堆后, 可以将时间复杂度降低到O(nlogk)级别 */
public class Solution {
  PriorityQueue<Integer> maxHeap, minHeap;

  public double[] medianSlidingWindow(int[] nums, int k) {
    // 注意点1:
    // 堆中存放index, 注意如果Comparator直接写 (i1, i2) -> nums[i1] - nums[i2] 会发生溢出
    // 所以下面使用了Comparator.comparingInt
    maxHeap =
        new PriorityQueue<>(
            Comparator.comparingInt((Integer i) -> nums[i]).reversed()); // 不指定Integer i会报错
    minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> nums[i]));

    double[] result = new double[nums.length - k + 1];
    int i = 0;
    int left = 0, right = 0;
    while (right < nums.length) {
      addToHeap(right, nums);
      right++;
      adjustHeap();

      if ((right - left) % k == 0) {
        // 注意点: 2 直接相加取平均值可能溢出
        if ((k & 1) == 1) result[i] = nums[maxHeap.peek()] * 1.0;
        else result[i] = nums[maxHeap.peek()] / 2.0 + nums[minHeap.peek()] / 2.0;
        i++;

        int num2 = nums[left];
        maxHeap.remove(left);
        minHeap.remove(left);
        adjustHeap();
        left++;
      }
    }

    return result;
  }

  void addToHeap(int index, int[] nums) {
    if (maxHeap.isEmpty() || nums[index] <= nums[maxHeap.peek()]) maxHeap.offer(index);
    else minHeap.offer(index);
  }

  void adjustHeap() {
    if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
    else if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
  }
}
