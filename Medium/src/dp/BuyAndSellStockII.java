package dp;

public class BuyAndSellStockII {

	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > prices[index - 1]) {
                maxProfit = maxProfit + (prices[index] - prices[index - 1]);
            }
        }
        
        return maxProfit;
    }
}
