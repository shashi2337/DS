package array;

public class SortColors {

	public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int curr = 0;
        
        while (curr <= twoIndex) {
            if (nums[curr] == 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = 0;
                nums[curr] = temp;
                zeroIndex++;
                curr++;
            } else if (nums[curr] == 2) {
                int temp = nums[twoIndex];
                nums[twoIndex] = 2;
                nums[curr] = temp;
                twoIndex--;
            } else {
                curr++;
            }
        }
    }
}
