import java.util.*;

public class AverageOfLevelsInBT {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static class Level {
		double total;
		int nums;
		Level(double total, int nums) {
			this.total = total;
			this.nums = nums;
		}
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(averageOfLevels(root));
    }
 
	private static List<Double> averageOfLevels(TreeNode root) {
		List<Level> levels = new ArrayList<>();
		helper(levels, root, 0);

		List<Double> res = new ArrayList<>();
		for (Level l : levels) {
			res.add(l.total / l.nums);
		}
		
		return res;
	}

	private static void helper(List<Level> levels, TreeNode node, int level) {
		if (node == null)	return;

		if (level >= levels.size()) {
			levels.add(new Level(node.val, 1));
		} else {
			levels.get(level).nums++;
			levels.get(level).total += node.val;
		}

		helper(levels, node.left, level + 1);
		helper(levels, node.right, level + 1);
	}
}