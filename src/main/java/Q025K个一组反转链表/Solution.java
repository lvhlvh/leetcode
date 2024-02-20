package Q025K个一组反转链表;

import common.ListNode;

/** https://leetcode.cn/problems/reverse-nodes-in-k-group/description/ 解法1: 基于反转链表II */
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    // 先计算链表长度, 然后才能根据剩余链表长度判断剩余链表是否需要反转
    int n = 0;
    ListNode cur = head;
    while (cur != null) {
      n++;
      cur = cur.next;
    }

    // 循环调用反转链表II的解
    ListNode result = head;
    for (int i = 0, nLeft = n; nLeft >= k; i++, nLeft -= k) {
      result = reverseBetween(result, k * i + 1, k * (i + 1));
    }
    return result;
  }

  private ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null || left == right) return head;

    ListNode dummyHead = new ListNode(-1, head);
    ListNode leftNodePrev = dummyHead, leftNode = head;
    int stepsToLeftNode = left - 1;
    while (stepsToLeftNode > 0) {
      leftNodePrev = leftNodePrev.next;
      leftNode = leftNode.next;
      stepsToLeftNode--;
    }

    ListNode prev = null, cur = leftNode;
    int subListLen = right - left + 1;
    while (subListLen > 0) {
      ListNode nextTmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = nextTmp;
      subListLen--;
    }

    leftNodePrev.next.next = cur;
    leftNodePrev.next = prev;

    return dummyHead.next;
  }
}
