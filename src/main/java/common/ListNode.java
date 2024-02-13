package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode cur = this;

        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        sb.append("null");

        return sb.toString();
    }
}