package Q322零钱兑换;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return 0;

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return coinChange(coins, amount, memo);
    }

    private int coinChange(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (memo[amount] != -2) return memo[amount];

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ret = coinChange(coins, amount - coin);
            if (ret == -1) continue;
            if (ret != Integer.MAX_VALUE) result = Math.min(result, ret + 1);
        }

        memo[amount] = (result == Integer.MAX_VALUE ? -1 : result);
        return memo[amount];
    }
}
