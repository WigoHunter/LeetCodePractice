import java.util.*;

public class LCAIII {
	private static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	private static class Result {
		boolean aFound, bFound;
		TreeNode node;
		Result(boolean a, boolean b, TreeNode n) {
			aFound = a;
			bFound = b;
			node = n;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		TreeNode t1 = new TreeNode(5);
		root.right.left = t1;
		TreeNode t2 = new TreeNode(6);
		root.right.right = t2;

		System.out.println(lowestCommonAncestor3(root, t1, t2).val);
	}

	private static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
		Result rt = helper(root, A, B);

		if (rt.aFound && rt.bFound)
			return rt.node;

		return null;
	}

	private static Result helper(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null)
			return new Result(false, false, null);

		Result left = helper(root.left, A, B);
		Result right = helper(root.right, A, B);

		boolean aFound = left.aFound || right.aFound || root == A;
		boolean bFound = left.bFound || right.bFound || root == B;

		if (root == A || root == B || (left.node != null && right.node != null)) {
			return new Result(aFound, bFound, root);
		}

		if (left.node != null) {
			return new Result(aFound, bFound, left.node);
		}

		if (right.node != null) {
			return new Result(aFound, bFound, right.node);
		}

		return new Result(aFound, bFound, null);
	}
}