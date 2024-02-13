package Q086分隔链表;

import common.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                tail.next = cur;
                cur = cur.next;
                tail = tail.next;
            }
        }

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val >= x) {
                tail.next = cur;
                cur = cur.next;
                tail = tail.next;
            }
        }

        tail.next = null;

        return dummyHead.next;
    }
}


