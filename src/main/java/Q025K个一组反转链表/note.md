# 解法1: 基于反转链表II

代码如下:
```java
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // 先计算链表长度, 然后才能根据剩余链表长度判断剩余链表是否需要反转
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        // 循环调用反转链表II的解
        ListNode result = head;
        for (int i = 0, nLeft = n; nLeft >= k; i++, nLeft -= k) {
            result = reverseBetween(result, k * i + 1, k * (i + 1));
        }
        return result;
    }

    private ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummyHead = new ListNode(-1, head);
        ListNode leftNodePrev = dummyHead, leftNode = head;
        int stepsToLeftNode = left - 1;
        while (stepsToLeftNode > 0) {
            leftNodePrev = leftNodePrev.next;
            leftNode = leftNode.next;
            stepsToLeftNode--;
        }

        ListNode prev = null, cur = leftNode;
        int subListLen = right - left + 1;
        while (subListLen > 0) {
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
            subListLen--;
        }

        leftNodePrev.next.next = cur;
        leftNodePrev.next = prev;

        return dummyHead.next;
    }
}
```
时间复杂度为`O(n)`。缺点是需要多次遍历数组, 求数组长度1次，然后每次反转也需要1次。

# 解法2

参考 [视频题解](https://www.youtube.com/watch?v=1UOPsfP85V4)

代码如下：
```java
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode dummyHead = new ListNode(-1, head);
    ListNode groupPrev = dummyHead;
    while (true) {
      ListNode kthNode = getKthNodeAfter(groupPrev, k);
      if (kthNode == null) break;

      ListNode groupNext = kthNode.next;
      // 反转链表算法
      ListNode prev = null, cur = groupPrev.next;
      while (cur != groupNext) {
        ListNode tmp = cur.next;
        cur.next = prev;

        prev = cur;
        cur = tmp;
      }
      groupPrev.next.next = cur;

      ListNode tmp = groupPrev.next;
      groupPrev.next = kthNode;
      groupPrev = tmp;
    }

    return dummyHead.next;
  }

  // helper方法: 找到cur节点后的第k个节点
  // 关键点: 通过返回null与否来区分cur后面够不够k个节点
  private ListNode getKthNodeAfter(ListNode cur, int k) {
    while (cur != null && k > 0) {
      cur = cur.next;
      k--;
    }
    return cur;
  }
}
```

该解法的优点在于只需要遍历一次链表。

该解法的技巧在于编写了一个helper方法来获取一个节点后面的第k个几点，并通过helper方法返回null与否来区分该节点后面够不够k个节点。

此外, 关于上面的`while(true)`，这样写能够更加清晰, 该写法等价于下面:

```java
ListNode kthNode = getKthNodeAfter(groupPrev, k);
while (kthNode != null) {
        // ...
        kthNode = getKthNodeAfter(groupPrev, k);
}
```

该题反转链表后修改指针的思路和反转链表II类似, 也是需要考虑反转部分前后的节点，如下图所示：
![](https://raw.githubusercontent.com/lvhlvh/pictures/master/imgreverse-k-group.png)