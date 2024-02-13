package Q086分隔链表;

import common.LinkedListUtil;
import common.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        ListNode list = LinkedListUtil.newLinkedList(1, 4, 3, 2, 5, 2);
        ListNode result = new Solution().partition(list, 3);
        LinkedListUtil.printLinkedList(result);
    }
}