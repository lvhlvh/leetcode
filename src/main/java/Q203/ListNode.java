package Q203;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int... arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr must not be null or 0 size");
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null)
                sb.append("->");
            cur = cur.next;
        }
        return sb.toString();
    }
}
