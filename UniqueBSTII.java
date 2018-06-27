import java.util.*;

public class MinimumPathSum {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		
	}

	private static List<TreeNode> generateTrees(int n) {
		return genTrees(1, n);
	}

	private static List<TreeNode> genTrees(int low, int high) {
		List<TreeNode> trees = new ArrayList<>();

		if (low > high) {
			trees.add(null);
			return trees;
		} else if (low == high) {
			trees.add(new TreeNode(low));
			return trees;
		} else {
			List<TreeNode> left, right;
			
			for (int i = low; i <= high; i++) {
				left = genTrees(low, i - 1);
				right = genTrees(i + 1, high);

				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode root = new TreeNode(i);
						root.left = l;
						root.right = r;
						trees.add(root);
					}
				}
			}
		}
			
		return trees;
	}
}