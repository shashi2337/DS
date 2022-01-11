package tree;

import datastructure.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
	public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return maxAncestorDiff(root, root.val, root.val);
    }
    
    private int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int left = maxAncestorDiff(root.left, min, max);
        int right = maxAncestorDiff(root.right, min, max);
        
        return Math.max(left, right);
    }
}
