// Cleaner solution available too. Check out SolutionOfDiameterOfBT
import java.util.*;

public class LongestUnivaluePath {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(1);

		System.out.println(minDepth(root));
    }
 
	private static int minDepth(TreeNode root) {
		if (root == null)	return 0;
		if (root.left == null && root.right != null)
			return minDepth(root.right) + 1;
		if (root.left != null && root.right == null)
			return minDepth(root.left) + 1;
		
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}