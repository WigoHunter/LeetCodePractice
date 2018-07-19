import java.util.*;

public class BSTToDoublyLinkedList {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static class DoublyListNode {
		int val;
		DoublyListNode next, prev;
		DoublyListNode(int val) {
			this.val = val;
		}
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		DoublyListNode node = bstToDoublyList(root);
		printList(node);
	}
    
    private static DoublyListNode bstToDoublyList(TreeNode root) {
		if (root == null)	return null;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		DoublyListNode prev = null;

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		while (!stack.isEmpty()) {
			cur = stack.pop();

			DoublyListNode next = new DoublyListNode(cur.val);
			next.prev = prev;
			if (prev != null) {
				prev.next = next;
			}
			prev = next;

			cur = cur.right;
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}

		while (prev.prev != null) {
			prev = prev.prev;
		}

		return prev;
	} 
	
	private static void printList(DoublyListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}