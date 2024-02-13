package Q015三数之和;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void threeSum() {
    Solution solution = new Solution();
    int[] nums = {1, -1, -1, 0};
    List<List<Integer>> lists = solution.threeSum(nums);
    for (List<Integer> list : lists) {
      System.out.println(list);
    }
  }

  @Test
  void twoSum() {}
}
