package 面试题1718最短超串;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void shortestSeq() {
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};
        int[] result = new Solution().shortestSeq(big, small);
        System.out.println(Arrays.toString(result));
    }
}