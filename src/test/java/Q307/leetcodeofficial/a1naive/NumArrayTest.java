package Q307.leetcodeofficial.a1naive;

import org.junit.jupiter.api.Test;

class NumArrayTest {
    @Test
    void test() {
        int[] nums = new int[]{1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}