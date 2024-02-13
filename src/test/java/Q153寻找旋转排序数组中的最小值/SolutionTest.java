package Q153寻找旋转排序数组中的最小值;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void findMin() {
    Solution solution = new Solution();
    Assertions.assertEquals(1, solution.findMin(new int[] {3, 4, 5, 1, 2}));
    Assertions.assertEquals(0, solution.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
  }

  @Test
  void findMin2() {
    Solution solution = new Solution();
    System.out.println(solution);
  }
}
