import java.util.*;

public class PopulatingNextRightPointers {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);

		connect(root);
    }
 
	private static void connect(TreeLinkNode root) {
		if (root == null) return;

		TreeLinkNode prev, cur;
		Queue<TreeLinkNode> q = new LinkedList<>();

		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			prev = null;
			
			for (int i = 0; i < size; i++) {
				cur = q.poll();
				if (cur == null)	continue;

				cur.next = null;
				if (prev != null) {
					prev.next = cur;
				}

				q.offer(cur.left);
				q.offer(cur.right);

				prev = cur;
			}
		}
	}
}