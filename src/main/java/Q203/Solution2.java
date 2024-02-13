package Q203;

/** 引入虚拟头结点 */
public class Solution2 {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.val == val) prev.next = prev.next.next;
      else prev = prev.next;
    }

    return dummyHead.next;
  }
}
