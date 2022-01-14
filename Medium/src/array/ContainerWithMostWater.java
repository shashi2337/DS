package array;

public class ContainerWithMostWater {
	
	public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        
        while (left < right) {
            int width = (right - left);
            int height = Math.min(heights[right], heights[left]);
            int currArea = width * height;
            max = Math.max(currArea, max);
            
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
