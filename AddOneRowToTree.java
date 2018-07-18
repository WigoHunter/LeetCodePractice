import java.util.*;

public class AddOneRowToTree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);

		root = addOneRow(root, 1, 2);
		
		printTreeByLevel(root);
    }
 
    private static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 0 || d == 1) {
			TreeNode r = new TreeNode(v);
			r.left = d == 1 ? root : null;
			r.right = d == 0 ? root : null;
			return r;
		}

		if (root == null)	return root;

		if (d > 1) {
			root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
			root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
		}

		return root;
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