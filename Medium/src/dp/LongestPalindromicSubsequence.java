package dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, - 1);
        }
        return lps(s, 0, s.length() - 1, dp);
    }
    
    private int lps(String s, int left, int right, int[][] dp) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        
        if (left == right) {
            dp[left][right] = 1;
            return dp[left][right];
        }
        
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);
        
        if (leftChar == rightChar) {
            if (left + 1 == right) {
                dp[left][right] = 2;
            } else {
                dp[left][right] = 2 + lps(s, left + 1, right - 1, dp);
            }
            return dp[left][right];
        }
        
        dp[left][right] = Math.max(lps(s, left + 1, right, dp), lps(s, left, right - 1, dp));
        return dp[left][right];
    }
}
