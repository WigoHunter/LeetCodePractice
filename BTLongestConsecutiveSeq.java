import java.util.*;

public class BTLongestConsecutiveSeq {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static int max = 0;

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);

		System.out.println(longestConsecutive(root));
	}
    
    private static int longestConsecutive(TreeNode root) {
		if (root == null)	return 0;

		helper(root.left, root.val, 1);
		helper(root.right, root.val, 1);

		return max;
	}

	private static void helper(TreeNode node, int prev, int count) {
		if (node == null)	return;

		if (node.val == prev + 1) {
			count = count + 1;
			max = Math.max(max, count);
		} else {
			count = 1;
		}

		helper(node.left, node.val, count);
		helper(node.right, node.val, count);
	}
}