[视频题解](https://www.youtube.com/watch?v=G0_I-ZF0S38)

# 解法1: Iterative

![](https://raw.githubusercontent.com/lvhlvh/pictures/master/imgRGIF2.gif)

需要两个指针 `prev` 和 `cur` （或者三个指针 `prev`, `cur`, `next`）。
依次遍历每个节点，执行如下操作：
* 先暂存`cur.next`到`next`，防止修改`cur.next`后找不到`cur`的后继结点
* 修改`cur.next`指向前一个节点`prev`
* 更新`prev, cur, next`

```java
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    // 注意这里prev的初始值赋值为null
    ListNode prev = null, cur = head;
    while (cur != null) {
      ListNode nextTmp = cur.next; // 暂存下一个节点: cur != null --> 可访问cur.next
      cur.next = prev;
      prev = cur;
      cur = nextTmp;
    }

    return prev;
  }
```

# 解法2: 递归
![](https://raw.githubusercontent.com/lvhlvh/pictures/master/img无标题-2023-08-12-1801.png)
思路: 第一个节点 拼上 reverse(余下的部分)

```java
 public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
```
