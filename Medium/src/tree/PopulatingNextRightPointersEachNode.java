package tree;

import datastructure.Node;

public class PopulatingNextRightPointersEachNode {
	
	public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Node leftmost = root;
        while (leftmost != null) {
            Node head = leftmost;
            while (head != null) {
                if (head.left != null) {
                    head.left.next = head.right;
                }
            
                if (head.right != null && head.next != null) {
                    head.right.next = head.next.left;
                }
            
                head = head.next;
            }
            
            leftmost = leftmost.left;
        }
        return root;
    }

}
