package Q300最长上升子序列;

import org.junit.jupiter.api.Test;

class Solultion2Test {

  private Solution2 solution = new Solution2();

  @Test
  void lengthOfLIS() {
    int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
    System.out.println(solution.lengthOfLIS(nums));
  }
}
