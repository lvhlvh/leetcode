package jianzhioffer.Q30最小的k个数;

import java.util.PriorityQueue;

public class Solution {
  public int[] getLeastNumbers(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k == 0) {
      return new int[0];
    }
    if (k > arr.length) {
      k = arr.length;
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
    for (int num : arr) {
      if (maxHeap.size() < k) {
        maxHeap.offer(num);
      } else {
        if (num < maxHeap.peek()) {
          maxHeap.poll();
          maxHeap.offer(num);
        }
      }
    }

    int[] result = new int[k];
    for (int i = 0; i < k; ++i) {
      result[i] = maxHeap.poll();
    }
    return result;
  }
}
