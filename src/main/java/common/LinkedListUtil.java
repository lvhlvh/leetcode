package common;

public class LinkedListUtil {

  public static ListNode newLinkedList(int... values) {
    if (values.length == 0) {
      return null;
    }

    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;

    for (int value : values) {
      cur.next = new ListNode(value);
      cur = cur.next;
    }

    return dummyHead.next;
  }
}
