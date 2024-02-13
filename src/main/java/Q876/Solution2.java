package Q876;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution2 {
  public ListNode middleNode(ListNode head) {
    if (head == null) return null;

    // 计算长度
    ListNode cur = head;
    int size = 0;
    while (cur != null) {
      size++;
      cur = cur.next;
    }

    // 根据长度计算需要移动次数
    cur = head;
    for (int i = 0; i < size / 2; ++i) cur = cur.next;

    return cur;
  }
}
