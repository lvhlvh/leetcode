package Q876;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */

/**
 * 快慢指针用在没有环的节点，一般是为了寻找中间节点（该问题的扩展: Q234回文链表，也需要先找中间节点）: 终止循环的条件： - 奇数个节点: fast.next == null -
 * 偶数个节点: fast == null
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode slow, fast;
    slow = fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
