package jianzhioffer.LCR021删除链表倒数第N个节点;

import common.ListNode;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 有可能删除的是第1个节点, 引入虚拟头结点方便操作
    ListNode dummyHead = new ListNode(-1, head);

    ListNode fast, slow;
    fast = slow = dummyHead;
    // 和寻找链表倒数第n个节点类似, 只不过这里是删除,
    // 需要找到倒数第n个节点的前一个节点, 所以k=n+1
    int k = n + 1;
    while (fast != null && k > 0) {
      fast = fast.next;
      k--;
    }

    if (k != 0) return null;

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    ListNode deletedNode = slow.next;
    slow.next = slow.next.next;
    deletedNode.next = null;

    return dummyHead.next;
  }
}
