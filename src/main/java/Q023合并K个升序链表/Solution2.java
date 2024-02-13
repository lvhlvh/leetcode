package Q023合并K个升序链表;

import common.ListNode;

/** 分治: 归并排序的思想 */
public class Solution2 {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    return mergeKLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeKLists(ListNode[] lists, int l, int r) {
    if (l == r) return lists[l];

    int mid = l + (r - l) / 2;
    ListNode l1 = mergeKLists(lists, l, mid);
    ListNode l2 = mergeKLists(lists, mid + 1, r);

    return mergeTwoLists(l1, l2);
  }

  private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    if (list1.val <= list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }
}
