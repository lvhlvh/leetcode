package Q024两两交换链表中的节点;

import common.ListNode;

public class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode dummyHead = new ListNode(-1, head);
    ListNode prev = dummyHead, cur = head;
    while (cur != null && cur.next != null) {
      prev.next = cur.next;
      ListNode tmp = cur.next.next;
      cur.next.next = cur;
      cur.next = tmp;

      prev = prev.next.next;
      cur = cur.next;
    }

    return dummyHead.next;
  }
}
