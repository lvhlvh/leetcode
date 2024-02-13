package Q480滑动窗口的中位数;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    void medianSlidingWindow() {
        int[] nums = {-2147483648, -2147483648, 2147483647,
                -2147483648, -2147483648, -2147483648,
                2147483647, 2147483647, 2147483647,
                2147483647, -2147483648, 2147483647,
                -2147483648};
        int k = 3;
        System.out.println(Arrays.toString(new Solution().medianSlidingWindow(nums, k)));
    }
}