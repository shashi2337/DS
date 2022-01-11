package dp;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int maxSubArray = nums[0];
        int minSubArray = nums[0];
        
        for (int index = 1; index < nums.length; index++) {
            int curr = nums[index];
            int tempMaxSubArray = Math.max(curr, Math.max(curr * maxSubArray, curr * minSubArray));
            minSubArray = Math.min(curr, Math.min(curr * maxSubArray, curr * minSubArray));
            maxSubArray = tempMaxSubArray;
            
            result = Math.max(result, maxSubArray);
        }
        
        return result;    
    }
}
