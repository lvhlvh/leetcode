package Q021;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = null;
    ListNode prev = dummyHead;

    while (cur1 != null && cur2 != null) {
      if (cur1.val <= cur2.val) {
        prev.next = cur1;
        cur1 = cur1.next;
      } else {
        prev.next = cur2;
        cur2 = cur2.next;
      }
      prev = prev.next;
    }

    if (cur1 != null) {
      prev.next = cur1;
    } else {
      prev.next = cur2;
    }

    return dummyHead.next;
  }
}
