package Q083;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution2 {
  // MYNOTE 递归
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) { // 只有0个或1个结点
      return head;
    }

    head.next = deleteDuplicates(head.next);
    return head.next.val == head.val ? head.next : head;
  }
}
