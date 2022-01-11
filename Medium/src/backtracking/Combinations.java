package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, result, new ArrayList<>());
        return result;
    }
    
    private void combine(int n, int k, int start, List<List<Integer>> result, List<Integer> curr) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
        }
        
        for (int index = start; index <= n; index++) {
            curr.add(index);
            combine(n, k, index + 1, result, curr);
            curr.remove(curr.size() - 1);
        }
        
    }

}
