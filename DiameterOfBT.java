// Cleaner solution available too. Check out SolutionOfDiameterOfBT
import java.util.*;

public class DiameterOfBT {
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
		root.left.left.left = new TreeNode(1);

		System.out.println(_diameterOfBinaryTree(root));
	}
	
	private static int max = Integer.MIN_VALUE;
 
    private static int _diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		getDepth(root);
		return max - 1;
	}

	private static int getDepth(TreeNode root) {
		if (root == null)	return 0;
		if (root.left == null && root.right == null) {
			root.val = 1;
		}

		int left = getDepth(root.left) + 1;
		int right = getDepth(root.right) + 1;
		int diameter = left + right - 1;
		if (diameter > max) {
			max = diameter;
		}

		return Math.max(left, right);
	}
}