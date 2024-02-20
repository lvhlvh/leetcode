package Q025K个一组反转链表;

import common.ListNode;

public class Solution2 {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode dummyHead = new ListNode(-1, head);
    ListNode groupPrev = dummyHead;
    while (true) {
      ListNode kthNode = getKthNodeAfter(groupPrev, k);
      if (kthNode == null) break;

      ListNode groupNext = kthNode.next;

      ListNode prev = null, cur = groupPrev.next;
      while (cur != groupNext) {
        ListNode tmp = cur.next;
        cur.next = prev;

        prev = cur;
        cur = tmp;
      }
      groupPrev.next.next = cur;

      ListNode tmp = groupPrev.next;
      groupPrev.next = kthNode;
      groupPrev = tmp;
    }

    return dummyHead.next;
  }

  // helper方法: 找到cur节点后的第k个节点
  // 关键点: 通过返回null与否来区分cur后面够不够k个节点
  private ListNode getKthNodeAfter(ListNode cur, int k) {
    while (cur != null && k > 0) {
      cur = cur.next;
      k--;
    }
    return cur;
  }
}
