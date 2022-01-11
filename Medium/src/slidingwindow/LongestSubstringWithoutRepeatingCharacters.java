package slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {
	
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int maxSubstring = 0;
        int left = 0;
        int right = 0;
        
        while (right < s.length()) {
            chars[s.charAt(right)]++;
            
            while (chars[s.charAt(right)] > 1) {
                chars[s.charAt(left)]--;
                left++;
            }
            
            maxSubstring = Math.max(maxSubstring, right - left + 1);
            right++;
        }
        
        return maxSubstring;
    }

}
