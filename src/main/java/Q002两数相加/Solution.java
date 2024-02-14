package Q002两数相加;

import common.ListNode;

/** 就是列竖式做加法的思路 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode resultDummyHead = new ListNode(-1);
    ListNode resultTail = resultDummyHead;
    ListNode p1 = l1, p2 = l2;

    int carry = 0;
    // 为了避免npe，这里循环的条件是这两个指针都不是null
    while (p1 != null && p2 != null) {
      int sum = p1.val + p2.val + carry;
      int onesPlace = sum % 10;
      carry = sum / 10;

      resultTail.next = new ListNode(onesPlace);
      resultTail = resultTail.next;

      p1 = p1.next;
      p2 = p2.next;
    }

    // 然后遍历剩下的不是null的链表
    while (p1 != null) {
      int sum = p1.val + carry;
      int onesPlace = sum % 10;
      carry = sum / 10;

      resultTail.next = new ListNode(onesPlace);
      resultTail = resultTail.next;

      p1 = p1.next;
    }

    while (p2 != null) {
      int sum = p2.val + carry;
      int onesPlace = sum % 10;
      carry = sum / 10;

      resultTail.next = new ListNode(onesPlace);
      resultTail = resultTail.next;

      p2 = p2.next;
    }

    if (carry != 0) {
      resultTail.next = new ListNode(carry);
    }

    return resultDummyHead.next;
  }
}
