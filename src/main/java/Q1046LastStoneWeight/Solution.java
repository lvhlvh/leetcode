package Q1046LastStoneWeight;

import java.util.PriorityQueue;

public class Solution {
  public int lastStoneWeight(int[] stones) {
    if (stones.length == 1) {
      return stones[0];
    }
    // 注意是大顶堆！！！
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int stone : stones) {
      maxHeap.add(stone);
    }
    while (maxHeap.size() > 1) {
      int x = maxHeap.remove();
      int y = maxHeap.remove();
      if (x != y) {
        maxHeap.add(x > y ? x - y : y - x);
      }
    }
    return maxHeap.size() == 1 ? maxHeap.peek() : 0;
  }
}
