package Q024两两交换链表中的节点;

import common.ListNode;

public class Solution2 {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode remaining = swapPairs(head.next.next);
    ListNode newHead = head.next;
    head.next.next = head;
    head.next = remaining;

    return newHead;
  }
}
