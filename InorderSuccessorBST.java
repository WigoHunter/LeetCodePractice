import java.util.*;

public class InorderSuccessorBST {
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
		TreeNode target = new TreeNode(8);
		root.left.right = target;
		root.right.right = new TreeNode(18);

		System.out.println(solution(root, target).val);
	}

	private static TreeNode solution(TreeNode root, TreeNode p) {
		TreeNode successor = null;

		while(root != null && root != p) {
			if (root.val > p.val) {
				successor = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

		if (root == null)
			return null;

		if (root.right == null) {
			return successor;
		}

		root = root.right;
		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = getStack(root, p.val);

		TreeNode node = stack.peek();
		if (node.right == null) {
			node = stack.pop();
			while (!stack.isEmpty() && stack.peek().right == node) {
				node = stack.pop();
			}

			return stack.pop();
		}

		node = stack.peek().right;

		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		return stack.pop();
	}

	private static Stack<TreeNode> getStack(TreeNode root, int target) {
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			
			if (cur.val == target) {
				return stack;
			} else if (cur.val > target) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}

		return stack;
	}
}