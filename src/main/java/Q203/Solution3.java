package Q203;

/**
 * 递归
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode remaining = removeElements(head.next, val);
        if (head.val == val) {
            return remaining;
        } else {
            head.next = remaining;
            return head;
        }
    }
}
