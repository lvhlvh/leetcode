package Q023合并K个升序链表;

import common.ListNode;
import java.util.PriorityQueue;

/** 小顶堆 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    // 判空!!!
    if (lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

    for (ListNode head : lists) {
      // 判空!!!
      if (head != null) {
        pq.add(head);
      }
    }

    ListNode dummyHead = new ListNode(-1);
    ListNode tail = dummyHead;

    while (!pq.isEmpty()) {
      ListNode minNode = pq.poll();
      tail.next = minNode;
      tail = tail.next;

      if (minNode.next != null) {
        pq.add(minNode.next);
      }
    }

    tail.next = null;
    return dummyHead.next;
  }
}
