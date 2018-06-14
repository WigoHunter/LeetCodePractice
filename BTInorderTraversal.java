// God-like solution - learnt from LeetCode
import java.util.*;

public class BTInorderTraversal {
	private static List<Integer> list = new ArrayList<>();

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		System.out.println(Arrays.toString(inorderTraversal(root).toArray()));
	}
	
	private static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)	return res;
		traverse(root, res);

		return res;
	}

	private static void traverse(TreeNode node, List<Integer> res) {
		if (node == null)	return;

		traverse(node.left, res);
		res.add(node.val);
		traverse(node.right, res);
	}
}