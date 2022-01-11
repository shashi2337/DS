package datastructure;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode() {
		this(0);
	}
	
	public TreeNode(int value) {
		this(0, null, null);
	}
	
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.val = value;
		this.left = left;
		this.right = right;
	}
	
}
