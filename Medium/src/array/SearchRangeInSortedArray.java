package array;

public class SearchRangeInSortedArray {
	public int[] searchRange(int[] nums, int target) {
        int firstOccurence = searchRange(nums, target, true);
        if (firstOccurence == -1) {
            return new int[]{-1, -1};
        }
        int secondOccurence = searchRange(nums, target, false);
        return new int[] {firstOccurence, secondOccurence};
    }
    
    private int searchRange(int[] nums, int target, boolean isFirstOccurence) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (isFirstOccurence) {
                    if (mid == low || nums[mid - 1] != target) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    if (mid == high || nums[mid + 1] != target) {
                        return mid;
                    }
                    low = mid + 1;
                } 
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}
