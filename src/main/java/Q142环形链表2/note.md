> 问题描述：
>
> [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)



## 解法1: HashSet记录访问过的节点

```java
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
```

## 解法2: Floyd 环检测算法 (快慢指针)

> https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/

<img src="https://pic.leetcode-cn.com/a4788076d4f3ad247c2023f92bb1585d05c5132ece7ed1205e2e171e25648adc-Picture1.png" style="zoom:48%;" />

在判断链表是够存在环的问题中，我们使用了快慢指针，仅需一次相遇即可。

在该问题中，我们需要借助两次相遇：

- 第一次是为了确定链表有环
  - 确定有环后，将快指针`fast`移到链表头`head`位置
- 第二次是为了确定链表的入口位置
  - 该步骤一开始快指针`fast`指向链表头`head`，慢指针指向环中某一位置
  - 然后每次移动一步快、慢指针`fast`和`slow`，它们相遇的地方就是环的入口

上述算法就是 **[Floyd环检测算法](https://en.wikipedia.org/wiki/Cycle_detection)**。原理可以参考这里的[题解](https://labuladong.gitee.io/algo/di-ling-zh-bfe1b/shuang-zhi-0f7cc/#%E5%88%A4%E6%96%AD%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E5%8C%85%E5%90%AB%E7%8E%AF)