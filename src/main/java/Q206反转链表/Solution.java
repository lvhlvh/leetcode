package Q206反转链表;

import common.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  /**
   * 直接在原链表上修改指针: 使用prev, cur两个指针 time: O(n) space: O(1)
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode prev = null, cur = head;
    while (cur != null) {
      ListNode nextTmp = cur.next; // 暂存下一个节点: cur != null --> 可访问cur.next
      cur.next = prev;
      prev = cur;
      cur = nextTmp;
    }

    return prev;
  }
}
