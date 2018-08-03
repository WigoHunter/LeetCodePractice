import java.util.*;

public class InorderPredecessorBST {
	private static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);

		System.out.println(inorderPredecessor(root, new TreeNode(3)).val);
	}

	private static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		TreeNode cur = root;
		TreeNode prev = null;
		Stack<TreeNode> stack = new Stack<>();

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		cur = null;
		while (!stack.isEmpty()) {
			prev = cur;
			cur = stack.pop();

			if (cur.val == p.val) {
				return prev;
			}

			TreeNode temp = cur.right;
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
		}

		return null;
	}
}