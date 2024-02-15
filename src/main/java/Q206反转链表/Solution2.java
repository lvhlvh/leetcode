package Q206反转链表;

import common.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution2 {
  /** 递归实现 */
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
