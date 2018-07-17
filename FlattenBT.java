import java.util.*;

public class FlattenBT {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		flatten(root);
		printTreeByLevel(root);
	}

	private static TreeNode prev = null;

	private static void flatten(TreeNode root) {
		if (root == null)	return;

		if (prev != null) {
			prev.left = null;
			prev.right = root;
		}

		prev = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
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