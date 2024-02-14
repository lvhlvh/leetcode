# 解法1: 递归

![](https://raw.githubusercontent.com/lvhlvh/pictures/master/img20240214195054.png)

利用链表的天然递归特性，先swap前两个节点，然后递归的swap余下的节点:
```java
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode remaining = swapPairs(head.next.next);
    ListNode newHead = head.next;
    head.next.next = head;
    head.next = remaining;

    return newHead;
  }
```

# 解法2: Iterative

![](https://raw.githubusercontent.com/lvhlvh/pictures/master/img20240214195150.png)

引入虚拟头结点方便操作, 需要两个指针`prev`, `cur`来操作指针实现节点的交换，交换步骤如上图所示。

```java
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode dummyHead = new ListNode(-1, head);
    ListNode prev = dummyHead, cur = head;
    while (cur != null && cur.next != null) {
      prev.next = cur.next;
      ListNode tmp = cur.next.next;
      cur.next.next = cur;
      cur.next = tmp;

      prev = prev.next.next;
      cur = cur.next;
    }

    return dummyHead.next;
  }
```