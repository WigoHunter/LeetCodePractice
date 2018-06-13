// Cleaner solution available too. Check out SolutionOfDiameterOfBT
import java.util.*;

public class BinaryTreePaths {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);

		System.out.println(Arrays.toString(binaryTreePaths(root).toArray()));
    }
 
	private static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)	return res;

		dfs(root, String.valueOf(root.val), res);
		return res;
	}

	private static void dfs(TreeNode node, String s, List<String> list) {
		if (node.left == null && node.right == null) {
			list.add(s);
			return;
		}
		
		if (node.left != null)	dfs(node.left, s + "->" + node.left.val, list);
		if (node.right != null) dfs(node.right, s + "->" + node.right.val, list);
	}
}