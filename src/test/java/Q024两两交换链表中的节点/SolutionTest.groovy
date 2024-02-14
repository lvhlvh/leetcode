package Q024两两交换链表中的节点

import common.LinkedListUtil
import spock.lang.Specification

class SolutionTest extends Specification {
    def "SwapPairs"() {
        when:
        def result = new Solution().swapPairs(LinkedListUtil.newLinkedList(2, 1, 4, 3))

        then:
        result.toString() == "1->2->3->4->null"
    }
}
