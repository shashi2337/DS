package dp;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		int currentSubArray = nums[0];
        int maxSubArray = nums[0];
        
        for (int index = 1; index < nums.length; index++) {
            int num = nums[index];
            currentSubArray = Math.max(num, currentSubArray + num);
            maxSubArray = Math.max(currentSubArray, maxSubArray);
        }
        
        return maxSubArray;
    }
}
