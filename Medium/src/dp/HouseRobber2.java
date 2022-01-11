package dp;

public class HouseRobber2 {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] nums, int start, int end) {
		if (end - start == 0) {
			return nums[start];
		}

		if (end - start == 1) {
			return Math.max(nums[start], nums[end]);
		}

		int[] dp = new int[end - start + 1];
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start + 1]);

		for (int index = start + 2; index <= end; index++) {
			dp[index - start] = Math.max(dp[index - start - 1], dp[index - start - 2] + nums[index]);
		}

		return dp[end - start];
	}
}
