package Q086分隔链表;

import common.ListNode;

/** https://leetcode.cn/problems/partition-list/description/ */
public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode lessThanDummyHead = new ListNode(-1), greaterOrEqualToDummyHead = new ListNode(-1);
    ListNode lessThanTail = lessThanDummyHead, greaterOrEqualToTail = greaterOrEqualToDummyHead;

    for (ListNode cur = head; cur != null; cur = cur.next) {
      if (cur.val < x) {
        lessThanTail.next = cur;
        lessThanTail = cur;
      } else {
        greaterOrEqualToTail.next = cur;
        greaterOrEqualToTail = cur;
      }
    }
    greaterOrEqualToTail.next = null;

    lessThanTail.next = greaterOrEqualToDummyHead.next;
    return lessThanDummyHead.next;

  }
}
