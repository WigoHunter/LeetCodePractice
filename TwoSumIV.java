import java.util.*;

public class TwoSumIV {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		System.out.println(findTarget(root, 9));
	}

	private static boolean findTarget(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		return dfs(root, set, k);
	}

	private static boolean dfs(TreeNode root, Set<Integer> set, int k) {
		if (root == null)	return false;

		if (set.contains(k - root.val))	return true;
		set.add(root.val);
		return dfs(root.left, set, k) || dfs(root.right, set, k);
	}
}
