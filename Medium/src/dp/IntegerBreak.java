package dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
	Map<Integer, Integer> memo = new HashMap<>();
    public int integerBreak(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxProduct = Math.max(maxProduct, i * integerBreak(n - i));
            maxProduct = Math.max(maxProduct, (n - i) * integerBreak(i));
            maxProduct = Math.max(maxProduct, (n - i) * i);
        }
        memo.put(n, maxProduct);
        return maxProduct;
    }
}
