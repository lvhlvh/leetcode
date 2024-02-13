package Q206反转链表;

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

    if (head.next == null) {
      return head;
    }

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
    // ListNode tmp = head;
    // ListNode secondNode = head.next;
    // head.next = null;
    // head = reverseList(secondNode);
    // secondNode.next = tmp;

    // return head;
  }
}
