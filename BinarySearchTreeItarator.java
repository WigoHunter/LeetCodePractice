// God-like solution - learnt from LeetCode
import java.util.*;

public class BinarySearchTreeItarator {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static class BSTIterator {
		private Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			TreeNode cur = root;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public int next() {
			TreeNode node = stack.pop();
			TreeNode cur = node;

			if (cur.right != null) {
				cur = cur.right;
				while(cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			}

			return node.val;
		}
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(20);

		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
    }
}