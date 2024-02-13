package Q141环形链表;

/** 设置两个指针，一个走的快，一个走的慢， 有环的话: 就像跑步，两个人速度不同迟早慢的会被追上 没有环的话：有一个指针会变成null */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;

    ListNode slow, fast;
    slow = fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast != null && fast.val == slow.val) return true;
    }

    return false;
  }
}
