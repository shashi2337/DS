package dp;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i + 1, "");
            String s2 = expand(s, i - 1, i + 1, s.charAt(i) + "");
            String curr = s1.length() > s2.length() ? s1 : s2;
            result = result.length() > curr.length() ? result : curr;
        }
        
        return result;
    }
    
    private String expand(String s, int left, int right, String curr) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            curr = s.charAt(left) + curr + s.charAt(right);
            left--;
            right++;
        }
        
        return curr;
    }
}
