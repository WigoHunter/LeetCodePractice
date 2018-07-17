import java.util.*;

public class BuildHeightTree {
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
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(5);

		buildHeightTree(root);
		printTreeByLevel(root);
	}

	private static void buildHeightTree(TreeNode root) {
		if (root == null)	return;
		if (root != null && root.left == null && root.right == null)	root.val = 1;

		buildHeightTree(root.left);
		buildHeightTree(root.right);

		if (root.left == null && root.right != null) {
			root.val = root.right.val + 1;
		} else if (root.left != null && root.right == null) {
			root.val = root.left.val + 1;
		} else if (root.left != null && root.right != null){
			root.val = Math.max(root.left.val, root.right.val) + 1;
		}
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