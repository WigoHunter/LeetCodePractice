import java.util.*;

public class BalancedBT {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		System.out.println(isBalanced(root));
	}

	private static boolean res = true;

	private static boolean isBalanced(TreeNode root) {
		if (root == null)	return true;

		getHeight(root);

		return res;
	}

	private static int getHeight(TreeNode root) {
		if (root == null)	return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (Math.abs(right - left) > 1) {
			res = false;
		}

		return Math.max(left, right) + 1;
	}
}