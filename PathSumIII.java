import java.util.*;

public class PathSumIII {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);

		System.out.println(pathSum(root, 8));
    }
 
	private static int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return dfsFindSumAndSeeIfThereWereSomethingWeCouldDeleteToGetSum(root, 0, sum, map);
	}

	private static int dfsFindSumAndSeeIfThereWereSomethingWeCouldDeleteToGetSum(TreeNode root, int curSum, int target, Map<Integer, Integer> previouslySeen) {
		if (root == null) return 0;

		curSum += root.val;
		int res = previouslySeen.getOrDefault(curSum - target, 0);
		previouslySeen.put(curSum, previouslySeen.getOrDefault(curSum, 0) + 1);

		res +=
			dfsFindSumAndSeeIfThereWereSomethingWeCouldDeleteToGetSum(root.left, curSum, target, previouslySeen)
			+ dfsFindSumAndSeeIfThereWereSomethingWeCouldDeleteToGetSum(root.right, curSum, target, previouslySeen);
		
		previouslySeen.put(curSum, previouslySeen.get(curSum) - 1);
		return res;
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