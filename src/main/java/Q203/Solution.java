package Q203;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {


    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) // prev.next.val == val 只需修改prev.next指针删除prev的下一个结点
                prev.next = prev.next.next;
            else // prev.next.val != val 则修改prev, 右移1位
                prev = prev.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, 2, 6, 3, 4, 5, 6);
        System.out.println(head);

        System.out.println(new Solution().removeElements(head, 6));
    }
}