package lintcode.Q062搜索旋转排序数组;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void search() {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{6, 8, 9, 1, 3, 5}, 5));
    }
}