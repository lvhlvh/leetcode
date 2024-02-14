package Q002两数相加;

import common.ListNode;

/** 相比Solution，Solution2进行了优化，减少了重复代码，主要区别现在与循环条件的不同 */
public class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode resultDummyHead = new ListNode(-1);
    ListNode resultTail = resultDummyHead;
    ListNode p1 = l1, p2 = l2;

    int carry = 0;
    // 把两个链表假想成等长的
    while (p1 != null || p2 != null) {
      // 如果一个链表已经到头了，则用0替代
      int x = (p1 == null) ? 0 : p1.val;
      int y = (p2 == null) ? 0 : p2.val;
      int sum = x + y + carry;

      carry = sum / 10;
      resultTail.next = new ListNode(sum % 10);
      resultTail = resultTail.next;

      if (p1 != null) p1 = p1.next;
      if (p2 != null) p2 = p2.next;
    }

    if (carry != 0) {
      resultTail.next = new ListNode(carry);
    }

    return resultDummyHead.next;
  }
}
