import java.util.*;

public class RecoverBST {
	private static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}
	
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);

		System.out.println(bstSwappedNode(root).val);
	}
	private static TreeNode first = null;
	private static TreeNode second = null;
	private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public static TreeNode bstSwappedNode(TreeNode root) {
		inorder(root);
		
		if (first != null && second != null) {
    		int temp = first.val;
    		first.val = second.val;
    		second.val = temp;   
		}
		
		return root;
	}
	
	public static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);

		if (first == null && prev.val >= root.val) {
			first = prev;
		}

		if (first != null && prev.val >= root.val) {
			second = root;
		}

		prev = root;

		inorder(root.right);
	}
}