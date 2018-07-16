import java.util.*;

public class ClosestBSTValue {
	private static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(18);

		System.out.println(closestValue(root, 8.4));
	}

	private static int closestValue(TreeNode root, double target) {
		if (root == null)	return 0;

		TreeNode lowerBound = getLowerBound(root, target);
		TreeNode upperBound = getUpperBound(root, target);

		if (upperBound == null && lowerBound != null)	return lowerBound.val;
		if (lowerBound == null && upperBound != null)	return upperBound.val;

		if (Math.abs(lowerBound.val - target) > Math.abs(upperBound.val - target)) {
			return upperBound.val;
		}

		return lowerBound.val;
	}

	private static TreeNode getLowerBound(TreeNode root, double target) {
		if (root == null)	return null;

		if (root.val == target) {
			return root;
		} else if (root.val > target) {
			return getLowerBound(root.left, target);
		}

		TreeNode lowerNode = getLowerBound(root.right, target);

		if (lowerNode == null) {
			return root;
		}

		return lowerNode;
	}

	private static TreeNode getUpperBound(TreeNode root, double target) {
		if (root == null)	return null;

		if (root.val == target) {
			return root;
		} else if (root.val < target) {
			return getUpperBound(root.right, target);
		}

		TreeNode upperNode = getUpperBound(root.left, target);

		if (upperNode == null) {
			return root;
		}

		return upperNode;
	}
}