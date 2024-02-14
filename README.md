* [1\. 二分查找 Binary Search](#1-%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE-binary-search)
* [2\. 双指针 Two Pointers](#2-%E5%8F%8C%E6%8C%87%E9%92%88-two-pointers)
  * [同向双指针](#%E5%90%8C%E5%90%91%E5%8F%8C%E6%8C%87%E9%92%88)
  * [反向双指针](#%E5%8F%8D%E5%90%91%E5%8F%8C%E6%8C%87%E9%92%88)
  * [链表和快慢指针](#%E9%93%BE%E8%A1%A8%E5%92%8C%E5%BF%AB%E6%85%A2%E6%8C%87%E9%92%88)
* [3\. 单调栈](#3-%E5%8D%95%E8%B0%83%E6%A0%88)



# 1. 二分查找 Binary Search

[笔记](https://github.com/lvhlvh/algorithm-notes/blob/master/02.%E5%BF%AB%E6%8E%92-%E5%BD%92%E5%B9%B6-%E4%BA%8C%E5%88%86.md)

| 题目                                                         | Solution                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | [代码](src/main/java/Q033搜索旋转排序数组/Solution.java)    |
| [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | [代码](./src/main/java/Q153寻找旋转排序数组中的最小值/Solution.java) |
| [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/) | [代码](./src/main/java/Q153寻找旋转排序数组中的最小值2/Solution.java) |
| [278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/) | [代码](./src/main/java/Q278第一个错误的版本/Solution.java)   |

# 2. 双指针 Two Pointers

[笔记](https://github.com/lvhlvh/algorithm-notes/blob/master/05.%E5%8F%8C%E6%8C%87%E9%92%88.md)

## 同向双指针

| 题目                                                         | Solution                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) | [代码](src/main/java/Q026删除排序数组中的重复项/Solution.java) |
| [160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) | [代码](src/main/java/Q160相交链表/Solution.java) [题解](src/main/java/Q160相交链表/note.md) |
| [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/) | [代码]() [题解]()                                            |
|                                                              |                                                              |
|                                                              |                                                              |

## 反向双指针

| 题目                                                         | Solution                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [1. 两数之和](https://leetcode-cn.com/problems/two-sum/) :m: | [代码1-双重循环](./src/main/java/Q001两数之和/Solution.java)  [代码2-HashMap ](./src/main/java/Q001两数之和/Solution2.java) [题解](./src/main/java/Q001两数之和/note.md) |
| [9. 回文数](https://leetcode-cn.com/problems/palindrome-number/) :m: | [代码](src/main/java/Q009回文数/Solution.java) 更多解法待补充 |
| [344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/) | [代码](./src/main/java/Q344反转字符串/Solution.java)         |
|                                                              |                                                              |
|                                                              |                                                              |

## 链表和快慢指针

| 题目                                                         | Solution                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/) | [代码](src/main/java/Q141环形链表/Solution.java)             |
| [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) | [代码1](./src/main/java/Q142环形链表2/Solution.java)  [代码2 ](./src/main/java/Q142环形链表2/Solution2.java) [题解](./src/main/java/Q142环形链表2/note.md) |
| [876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list/) | [代码](src/main/java/Q876链表的中间节点/Solution.java)       |
| [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/) | [代码](src/main/java/jianzhioffer/Q22链表中倒数第k个节点/Solution.java) |
| [LCR 021. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/SLwz0R/) | [代码](src/main/java/jianzhioffer/LCR021删除链表倒数第N个节点/Solution.java) [题解](src/main/java/jianzhioffer/LCR021删除链表倒数第N个节点/note.md) |



# 3. 单调栈 Monotone Stack

[笔记](https://github.com/lvhlvh/algorithm-notes/blob/master/07.%E5%8D%95%E8%B0%83%E6%A0%88%E5%8D%95%E8%B0%83%E9%98%9F%E5%88%97%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3.md)

| 题目                                                         | Solution                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |
| [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/) | [代码](src/main/java/Q496下一个更大元素I/Solution.java)  栈存放元素 |
| [503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/) | [代码](src/main/java/Q503下一个更大元素II/Solution.java)  栈存放元素 |
| [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/) | [代码](src/main/java/Q739每日温度/Solution.java)  栈存放下标 |
|                                                              |                                                              |
|                                                              |                                                              |



# 4. 回溯算法/深度优先搜索 Backtrack/DFS 

[笔记](https://github.com/lvhlvh/algorithm-notes/blob/master/08.%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95DFS.md) 

| 题目                                                         | Solution                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [46. 全排列](https://leetcode-cn.com/problems/permutations/) | [代码](src/main/java/Q046全排列/Solution.java)               |
| [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/) | [代码](src/main/java/Q047全排列II/Solution.java) [题解](./src/main/java/Q047全排列II/note.md) |
| [剑指 Offer 38. 字符串的排列](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/) | [代码](src/main/java/jianzhioffer/Q38字符串的排列/Solution.java) |
|                                                              |                                                              |
|                                                              |                                                              |
|                                                              |                                                              |
|                                                              |                                                              |

# 5. 广度优先搜索 BFS

[笔记](https://github.com/lvhlvh/algorithm-notes/blob/master/09.BFS.md)

| 题目                                                         | Solution                                                 |
| ------------------------------------------------------------ | -------------------------------------------------------- |
| [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/) | [代码](src/main/java/Q111二叉树的最小深度/Solution.java) |
| [752. 打开转盘锁](https://leetcode-cn.com/problems/open-the-lock/) | [代码](src/main/java/Q752打开转盘锁/Solution.java)       |
|                                                              |                                                          |
|                                                              |                                                          |
|                                                              |                                                          |

# 6. 动态规划 Dynamic Programming

[笔记]()

| 题目                                                         | Solution                                                 |
| ------------------------------------------------------------ | -------------------------------------------------------- |
| [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | [代码1](src/main/java/Q300最长上升子序列/Solution.java) [代码2](src/main/java/Q300最长上升子序列/Solution2.java)|
| [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change) | [代码](src/main/java/Q322零钱兑换/Solution.java)       |
|                                                              |                                                          |
|                                                              |                                                          |
|                                                              |                                                          |