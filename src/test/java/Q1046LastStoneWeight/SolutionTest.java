package Q1046LastStoneWeight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void lastStoneWeight() {
    int result = new Solution().lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1});
    assertEquals(1, result);
  }
}
