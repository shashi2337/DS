package dp;

public class MaxLengthOfPositiveProduct {
	
public int getMaxLen(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        int pos = 0;
        int neg = 0;
        int result = 0;
        
        for (int num : nums) {
            if (num == 0) {
                pos = 0;
                neg = 0;
            } else if (num > 0) {
                pos++;
                if (neg > 0) {
                    neg++;
                }
            } else {
                int temp = pos;
                pos = neg;
                neg = temp;
                neg++;
                
                if (pos > 0) {
                    pos++;
                }
            }
            
            result = Math.max(pos, result);
        }
        
        return result;
    }

}
