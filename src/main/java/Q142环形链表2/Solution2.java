package Q142环形链表2;

/** Floyd环检测算法 */
public class Solution2 {
  public ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) break;
    }

    // 没有环
    if (fast == null || fast.next == null) return null;

    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }

    return fast;
  }
}
