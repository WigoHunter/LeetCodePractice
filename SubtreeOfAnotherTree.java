import java.util.*;

public class SubtreeOfAnotherTree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		System.out.println(isSubtree(root, t));
    }
 
	private static boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null)	return false;

		return compare(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private static boolean compare(TreeNode s, TreeNode t) {
		if ((s == null && t != null) || (s != null && t == null)) {
			return false;
		}

		if (s == null && t == null)	return true;

		if (s.val == t.val) {
			return compare(s.left, t.left) && compare(s.right, t.right);
		} else {
			return false;
		}
	}
}