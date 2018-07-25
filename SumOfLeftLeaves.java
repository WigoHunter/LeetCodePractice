import java.util.*;

public class SumOfLeftLeaves {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(sumOfLeftLeaves(root));
    }
 
	private static int sumOfLeftLeaves(TreeNode root) {
		if (root == null)	return 0;

		if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		}

		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}