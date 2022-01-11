package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructure.TreeNode;

public class AllPossibleBinaryTrees {
	private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        if (!memo.containsKey(n)) {
            List<TreeNode> result = new ArrayList<>();
            if (n == 1) {
                result.add(new TreeNode(0));
            } else if (n % 2 == 1) {
                for (int x = 0; x < n; x++) {
                    int y = n - x - 1;
                    List<TreeNode> leftSubtree = allPossibleFBT(x);
                    List<TreeNode> rightSubtree = allPossibleFBT(y);
                    for (TreeNode left : leftSubtree) {
                        for (TreeNode right : rightSubtree) {
                            TreeNode node = new TreeNode();
                            node.left = left;
                            node.right = right;
                            result.add(node);
                        }
                    }
                }
            }
            memo.put(n, result);
        }
        
        return memo.get(n);
    }
}
