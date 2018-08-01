// God-like solution - learnt from LeetCode
import java.util.*;

public class ValidateBSTII {
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

		TreeNode node = new TreeNode(2147483647);

		System.out.println(isValidBST(root));
		System.out.println(isValidBST(node));
	}
	
	private static boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	private static boolean isValid(TreeNode root, Integer atLeast, Integer atMost) {
		if (root == null) {
			return true;
		}

		if ((atLeast == null || root.val > atLeast) && (atMost == null || root.val < atMost)) {
			return isValid(root.left, atLeast, root.val) && isValid(root.right, root.val, atMost);
		}

		return false;
	}
}