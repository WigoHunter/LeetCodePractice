import java.util.*;

public class KthSmallestInBST {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);

		System.out.println(kthSmallest(root, 3));
	}
	
	private static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		while (k > 0) {
			cur = stack.pop();
			k--;

			if (k == 0)	{
				return cur.val;
			} else {
				TreeNode right = cur.right;

				while (right != null) {
					stack.push(right);
					right = right.left;
				}
			}
		}

		return -1;
	}
}