package Q876链表的中间节点;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

/** 借助快慢指针，当fast == null 或 fast.next == null时, slow对应的就是中间(偏后)的节点 */
public class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    // 关于while条件:
    // 思考方式1:
    // fast.next != null控制奇数个节点链表的停止条件
    // fast != null控制偶数个节点链表的停止条件
    // 思考方式2:
    // 要想快指针能往后移动两位, 必须fast!=null且fast.next!=null
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
