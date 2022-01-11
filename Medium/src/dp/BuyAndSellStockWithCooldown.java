package dp;

public class BuyAndSellStockWithCooldown {
	
	public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int cooldown = 0;
        
        for (int num : prices) {
            int tempsold = sold;
            hold = Math.max(hold, cooldown - num);
            sold = hold + num;
            cooldown = Math.max(cooldown, tempsold);
        }
        
        return Math.max(cooldown, sold);
    }

}
