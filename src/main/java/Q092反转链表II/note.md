[视频题解](https://www.youtube.com/watch?v=RF_M9tX4Eag)

其实这题底层还是基于反转链表那题的思路，只不过反转的是一个sublist。

![](https://raw.githubusercontent.com/lvhlvh/pictures/master/imgreverse-sublist.png)

代码如下:
```java
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        // 这题需要dummyHead
        ListNode dummyHead = new ListNode(-1, head);
        ListNode leftPrev = dummyHead, leftNode = dummyHead.next;

        // 1. 先找到subList的左端点, 同时找到左端点的前一个节点leftPrev
        int nStepsToLeft = left - 1;
        while (nStepsToLeft > 0) {
            leftPrev = leftPrev.next;
            leftNode = leftNode.next;
            nStepsToLeft--;
        }

        // 2. 开始反转链表(算法同反转链表)
        ListNode prev = null, cur = leftNode;
        int subListLen = right - left + 1;
        ListNode nextTmp = null;
        while (subListLen > 0) {
            nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
            subListLen--;
        }

        // 3. 调整指针
        leftPrev.next.next = cur;
        leftPrev.next = prev;

        return dummyHead.next;
    }
}

```