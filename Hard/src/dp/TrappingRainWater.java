package dp;

public class TrappingRainWater {
	public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int maxLeft = 0;
        int maxRight = 0;
        int ans = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (maxLeft > height[left]) {
                    ans += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                if (maxRight > height[right]) {
                    ans += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }
        
        return ans;
    }
}
