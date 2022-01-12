package dp;

import java.util.Arrays;

public class DecodeWays {
	public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecoding(s, 0, memo);
    }
    
    private int numDecoding(String s, int start, int[] memo) {
        if (start == s.length()) {
            return 1;
        }
        
        if (memo[start] != -1) {
            return memo[start];
        }
        
        if (s.charAt(start) == '0') {
            return 0;
        }
        
        if (start == s.length() - 1) {
            return 1;
        }
        
        int ans = numDecoding(s, start + 1, memo);
        if (Integer.parseInt(s.substring(start, start + 2)) <= 26) {
            ans += numDecoding(s, start + 2, memo);
        }
        
        memo[start] = ans;
        return ans;
    }
}
