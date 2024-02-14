package Q024两两交换链表中的节点

import common.LinkedListUtil
import spock.lang.Specification

class Solution2Test extends Specification {

    def test() {
        when:
        def result = new Solution2().swapPairs(LinkedListUtil.newLinkedList(1, 2, 3, 4))

        then:
        result.toString() == "2->1->4->3->null"
    }
}
