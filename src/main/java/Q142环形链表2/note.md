> 问题描述：
>
> [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)



## 解法1: HashSet记录访问过的节点

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

上述算法就是 **[Floyd环检测算法](https://en.wikipedia.org/wiki/Cycle_detection)**。

### 证明

该算法的证明如下:

假设**非环部分**有a个节点，**环**中有b个节点。显然，从链表头`head`走a步就能到换入口。

在第一次相遇时，假设快指针走了`f`步，慢指针走了`s`步，则显然有：`f = 2s`

并且又有 `f = s + nb`（显然快指针比慢指针多走了n个环的长度）。

由上面两个式子可以得到：`f = 2nb, s = nb`。

--------

而我们要找环的入口，要走到环的入口，需要经过 `a + nb`步，显然，快、慢指针不管谁**再走`a`步**，就能到达环入口。

----------

:question: ​但是我们**并不知道a的值**，如何让快指针或慢指针走额外的`a`步呢？

还是利用**双指针的思想**，我们可以让快慢指针其中一个指向链表头`head`，假设让快指针`fast = head`，然后移动快慢指针**每次一步**。这样，当快指针`fast`移动`a`步到环入口时（`fast`走了`a`步），慢指针也移动`a`步走到了环入口（总共`a + nb`步），也就是，**第二次相遇的地方就是环入口**。