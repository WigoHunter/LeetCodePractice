import java.util.*;

public class ClosestBSTValueII {
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
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(18);

		System.out.println(closestKValues(root, 8.4, 3));
	}

	private static List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();
		if (k == 0 || root == null)	return res;

		Stack<TreeNode> lowerStack = getStack(root, target);
		Stack<TreeNode> upperStack = new Stack<>();
		upperStack.addAll(lowerStack);
		// Stack<Integer> stackFromUpper = getStackFromUpper(upperBound);
		
		if (target < lowerStack.peek().val) {
			moveLower(lowerStack);
		} else {
			moveUpper(upperStack);
		}

		printStack(upperStack);
		
		while (k > 0) {
			if (lowerStack.isEmpty() || 
					!upperStack.isEmpty() && target - lowerStack.peek().val > upperStack.peek().val - target) {
				res.add(upperStack.peek().val);
				moveUpper(upperStack);
			} else {
				res.add(lowerStack.peek().val);
				moveLower(lowerStack);
			}

			k--;
		}
		
		return res;
	}

	private static void printStack(Stack<TreeNode> s) {
		Stack<TreeNode> stack = new Stack<>();
		stack.addAll(s);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop().val + " ");
		}
		System.out.println(sb.toString());
	} 

	private static Stack<TreeNode> getStack(TreeNode root, double target) {
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
			stack.push(root);

			if (root.val > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return stack;
	}

	private static void moveUpper(Stack<TreeNode> stack) {
		TreeNode node = stack.peek();

		if (node.right == null) {
			node = stack.pop();
			while (!stack.isEmpty() && stack.peek().right == node) {
				node = stack.pop();
			}

			return;
		}

		node = node.right;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	private static void moveLower(Stack<TreeNode> stack) {
		TreeNode node = stack.peek();

		if (node.left == null) {
			node = stack.pop();
			while (!stack.isEmpty() && stack.peek().left == node) {
				node = stack.pop();
			}

			return;
		}

		node = node.left;
		while (node != null) {
			stack.push(node);
			node = node.right;
		}
	}
}