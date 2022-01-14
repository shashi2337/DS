package dp;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }
    
    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        
        if (amount < 0) {
            return -1;
        }
        
        if (dp[amount - 1] != 0) {
            return dp[amount - 1];
        }
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int curr = coinChange(coins, amount - coin, dp);
            if (curr >= 0) {
                min = Math.min(min, 1 + curr);
            }
        }
        
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount - 1];
    }
}
