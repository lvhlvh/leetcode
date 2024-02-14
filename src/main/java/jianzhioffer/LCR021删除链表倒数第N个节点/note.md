[题解](https://leetcode.cn/problems/SLwz0R/solutions/1417848/shan-chu-lian-biao-de-dao-shu-di-n-ge-ji-ydte/)

* 解法1: 先一次遍历计算出链表的长度, 然后再一次遍历找到倒数第n+1个节点 
* 解法2: 借助栈。先遍历一次，每遍历一个节点都将该节点入栈，将链表的所有节点入栈。然后pop n+1次得到倒数第n个节点的前一个节点，操作删除。 
* 解法3：快慢指针。和寻找链表倒数第n个节点类似，这里需要找到链表倒数第n+1个节点。