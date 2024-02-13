package Q322零钱兑换;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void coinChange() {
    int[] coins = {1, 2, 5};
    int amount = 11;
    System.out.println(new Solution().coinChange(coins, amount));
  }
}
