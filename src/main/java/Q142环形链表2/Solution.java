package Q142环形链表2;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 *
 * <p>基于HashSet的解法:
 *
 * <p>遍历链表，同时用一个HashSet visited记录已经访问过的节点， 遍历过程中每次循环检查当前节点是够已经出现在visited中了，
 * 如果是，说明存在环且当前节点即为入口节点，直接返回
 *
 * <p>时间复杂度O(n), 空间复杂度O(n)
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();

    ListNode cur = head;
    while (cur != null) {
      if (set.contains(cur)) return cur;

      set.add(cur);
      cur = cur.next;
    }

    return null;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
