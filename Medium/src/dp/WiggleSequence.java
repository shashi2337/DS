package dp;

public class WiggleSequence {

	public int wiggleMaxLength(int[] nums) {
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[j] < nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        
        return 1 + Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
	
}
