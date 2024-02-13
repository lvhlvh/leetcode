package Q086分隔链表

import common.LinkedListUtil
import common.ListNode
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Subject([Solution])
class SolutionTest extends Specification {

    @Unroll
    def "Partition"() {
        when:
        ListNode result = new Solution().partition(LinkedListUtil.newLinkedList(*list), x);

        then:
        result
        result.toString() == expResultStr

        where:
        list               | x | expResultStr
        [1, 4, 3, 2, 5, 2] | 3 | "1->2->2->4->3->5->null"
        [5, 1, 2, 6, 1, 5] | 3 | "1->2->1->5->6->5->null"
    }
}
