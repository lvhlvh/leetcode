package Q206反转链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution3 {
    /**
     * time: O(n)
     * space: O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode reversedList = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;

            if (reversedList == null) {
                reversedList = tmp;
                tmp.next = null;
            } else {
                tmp.next = reversedList;
                reversedList = tmp;
            }
        }

        return reversedList;
    }
}