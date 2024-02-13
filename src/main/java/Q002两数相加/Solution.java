package Q002两数相加;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1); // dummyHead
        ListNode tail = ret;

        ListNode cur1 = l1, cur2 = l2;
        int c = 0; // 进位
        while (cur1 != null || cur2 != null) {
            int sum = c;
            if (cur1 != null) {
                sum += cur1.val; // 必须cur1 != null, 才能cur1.val
                cur1 = cur1.next; // 必须cur1 != null, 才能cur1 = cur1.next
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }

            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            c = sum / 10;
        }

        if (c != 0) {
            tail.next = new ListNode(c);
            tail = tail.next;
        }

        return ret.next;
    }

}