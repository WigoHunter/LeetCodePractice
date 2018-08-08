import java.util.*;

public class BTVerticalOrderTraverse {
	private static class TreeNode {
		int val;
		TreeNode right, left;

		TreeNode(int val) {
			this.val = val;
		}
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(2);
		root.right.left.left = new TreeNode(5);

		System.out.println(Arrays.toString(verticalOrder(root).toArray()));
	}

	private static List<List<Integer>> verticalOrder(TreeNode root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		List<List<Integer>> res = new ArrayList<>();
		
		visit(map, root, 0);

		for (List<Integer> list : map.values()) {
			res.add(list);
		}

		return res;
	}

	private static void visit(Map<Integer, List<Integer>> map, TreeNode node, int key) {
		if (node == null)	return;

		List<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());
		list.add(node.val);

		map.put(key, list);
		visit(map, node.left, key - 1);
		visit(map, node.right, key + 1);
	}
}