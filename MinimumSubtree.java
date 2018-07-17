import java.util.*;

public class MinimumSubtree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-5);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.right.left = new TreeNode(-4);
		root.right.right = new TreeNode(-5);

		System.out.println(findSubtree(root).val);

		printTreeByLevel(root);
	}
	
	private static int minSum = Integer.MAX_VALUE;
	private static TreeNode res;
 
	private static TreeNode findSubtree(TreeNode root) {
		helper(root);
		return res;
	}

	private static int helper(TreeNode root) {
		if (root == null)	return 0;

		int sum = helper(root.left) + helper(root.right) + root.val;
		if (sum <= minSum) {
			res = root;
			minSum = sum;
		}

		return sum;
	}

	private static void printTreeByLevel(TreeNode root) {
		Map<Integer, List<TreeNode>> map = new HashMap<>();

		buildMap(root, 0, map);

		for (List<TreeNode> list : map.values()) {
			for (TreeNode n : list) {
				System.out.print(n.val + " ");
			}
			System.out.println();
		}
	}

	private static void buildMap(TreeNode node, int level, Map<Integer, List<TreeNode>> map) {
		if (node == null)	return;

		List<TreeNode> list = map.getOrDefault(level, new ArrayList<>());
		list.add(node);
		map.put(level, list);

		buildMap(node.left, level + 1, map);
		buildMap(node.right, level + 1, map);
	}
}