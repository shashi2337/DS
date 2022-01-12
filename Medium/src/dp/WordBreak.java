package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }
    
    public boolean wordBreak(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        
        if(memo[start] != null) {
            return memo[start];
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && wordBreak(s, end, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        
        memo[start] = false;
        return false;
    }
}
