// Cleaner solution available too. Check out SolutionOfDiameterOfBT
import java.util.*;

public class DiameterOfBinaryTree {
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
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(_diameterOfBinaryTree(root));
    }
 
    private static int _diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int max = 0;
		return findMax(max, root);
	}

	private static int findMax(int max, TreeNode root) {
		if (root == null)
			return max;
		
		max = Math.max(max, findDiameter(root));
		max = findMax(max, root.left);
		max = findMax(max, root.right);

		return max;
	}

	private static int findDiameter(TreeNode root) {
		return (root.left == null ? 0 : 1 + maxLength(root.left)) + (root.right == null ? 0 : 1 + maxLength(root.right));
	}

	private static int maxLength(TreeNode root) {
		if (root.left == null) {
			if (root.right == null)
				return 0;
			else
				return 1 + maxLength(root.right);
		} else {
			if (root.right == null) {
				return 1 + maxLength(root.left);
			} else {
				return Math.max(1 + maxLength(root.left), 1 + maxLength(root.right));
			}
		}
	}
}