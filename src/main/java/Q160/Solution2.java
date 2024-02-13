package Q160;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution2 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 边界条件
    if (headA == null || headB == null) return null;

    ListNode curA = headA;
    ListNode curB = headB;
    while (curA != curB) {
      curA = curA == null ? headB : curA.next;
      curB = curB == null ? headA : curB.next;
    }
    return curA;
  }
}
