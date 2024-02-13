package Q018四数之和;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void fourSum() {
    Solution solution = new Solution();
    int[] nums = {1, 0, -1, 0, -2, 2};
    List<List<Integer>> lists = solution.fourSum(nums, 0);
    for (List<Integer> list : lists) {
      System.out.println(list);
    }
  }

  @Test
  void nSum() {}
}
