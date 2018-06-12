// Cleaner solution available too. Check out SolutionOfDiameterOfBT
import java.util.*;

public class SolutionOfDiameterOfBT {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static int ans;

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(diameterOfBT(root));
    }
 
	private static int diameterOfBT(TreeNode root) {
		ans = 1;
		depth(root);
		return ans - 1;
	}

	private static int depth(TreeNode node) {
		if (node == null)	return 0;

		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
	}
}