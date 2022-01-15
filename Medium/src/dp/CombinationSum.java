package dp;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum {
	
	public int combinationSum4(int[] nums, int target) {
        return combination(nums, target, new HashMap<Integer, Integer>());
    }
    
    private int combination(int[] nums, int remain, Map<Integer, Integer> memo) {
        if (remain == 0) {
            return 1;
        }
        
        if (memo.containsKey(remain)) {
            return memo.get(remain);
        }
        
        int result = 0;
        for (int num : nums) {
            if (remain - num >= 0) {
                result += combination(nums, remain - num, memo);
            }
        }
        
        memo.put(remain, result);
        return result;
    }

}
