package dp;

public class MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int curMax = nums[0], max = nums[0];
        int curMin = nums[0], min = nums[0];
        int totalSum = nums[0];
        
        for (int i = 1; i < n; i++) {
            totalSum += nums[i];
            curMax = Math.max(nums[i], curMax + nums[i]);
            max = Math.max(curMax, max);
            
            curMin = Math.min(nums[i], curMin + nums[i]);
            min = Math.min(curMin, min);
        }
        
        return totalSum == min ? max : Math.max(max, totalSum - min);
    }
}
