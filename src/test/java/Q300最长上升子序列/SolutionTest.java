package Q300最长上升子序列;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void lengthOfLIS() {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(solution.lengthOfLIS(nums));
    }
}