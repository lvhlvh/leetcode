package Q160相交链表;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {
  /**
   * time: O(m + n) space: O(m) or O(n)
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> record = new HashSet<>();
    ListNode curA = headA;
    ListNode curB = headB;

    while (curA != null) {
      record.add(curA);
      curA = curA.next;
    }

    while (curB != null) {
      if (record.contains(curB)) return curB;
      curB = curB.next;
    }

    return null;
  }
}
