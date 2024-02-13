package jianzhioffer.Q22链表中倒数第k个节点;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 注意: k 可能大于链表长度
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && k-- > 0) fast = fast.next;
        // k > 0 则 fast 一定是 null, 说明k大于链表长度
        if (k > 0) return null;
        // fast和slow之间始终维持固定的间距，这也是双指针的用处之一
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
