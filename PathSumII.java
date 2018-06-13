import java.util.*;

public class PathSumII {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		List<List<Integer>> res = pathSum(root, 22);
		System.out.println(Arrays.toString(res.toArray()));
    }
 
	private static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		dfs(root, sum, list, res);
		return res;
	}

	private static void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
		if (root == null) return;

		list.add(root.val);
		sum -= root.val;

		if (root.right == null && root.left == null && sum == 0) {
			List<Integer> temp = new ArrayList<>(list);
			res.add(temp);
			return;
		}
		
		if (root.right != null) {
			dfs(root.right, sum, list, res);
			list.remove(list.size() - 1);
		}
		
		if (root.left != null) {
			dfs(root.left, sum, list, res);
			list.remove(list.size() - 1);
		}
	}

	/*
	private static int depth(TreeNode node) {
		if (node == null)	return 0;

		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
	}
	*/
}