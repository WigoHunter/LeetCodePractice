import java.util.*;

public class BTZigzagLevelOrderTraversal {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(Arrays.toString(zigzagLevelOrder(root).toArray()));
    }
 
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> levels = new HashMap<>();

		traverse(root, 0, levels);

		for (int key : levels.keySet()) {
			res.add(levels.get(key));
		}

		return res;
	}

	private static void traverse(TreeNode root, int level, Map<Integer, List<Integer>> levels) {
		if (root == null)	return;

		List<Integer> list = levels.getOrDefault(level, new ArrayList<>());
		
		if (level % 2 != 0) {
			list.add(0, root.val);
		} else {
			list.add(list.size(), root.val);
		}

		levels.put(level, list);

		if (root.left != null)
			traverse(root.left, level + 1, levels);
		if (root.right != null)
			traverse(root.right, level + 1, levels);
	}
}