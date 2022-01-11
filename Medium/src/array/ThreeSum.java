package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int pivot = 0; pivot < nums.length; pivot++) {
            if (pivot == 0 || nums[pivot] != nums[pivot - 1]) {
                twoSum(nums, pivot, pivot + 1, nums.length - 1, result);
            }
        }
        return result;
    }
    
    private void twoSum(int[] nums, int pivot, int low, int high, List<List<Integer>> result) {
        
        
        while (low < high) {
            int sum = nums[pivot] + nums[low] + nums[high];
            if (sum == 0) {
                result.add(Arrays.asList(new Integer[] {nums[pivot], nums[low], nums[high]}));
                low++;
                high--;
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            } else if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
    }
}
