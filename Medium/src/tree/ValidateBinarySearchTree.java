package tree;

import datastructure.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        
        if (low != null && low >= root.val) {
            return false;
        }
        
        if (high != null && high <= root.val) {
            return false;
        }
        
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }
}
