// Would build a BSTIterator class first. To clean up the code.
import java.util.*;

public class FindModeInBST {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		/*
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(2);
		root.right.right.right = new TreeNode(3);
		root.right.right.right.left = new TreeNode(2);
		root.right.right.right.right = new TreeNode(4);
		root.right.right.right.right.left = new TreeNode(3);
		root.right.right.right.right.left.left = new TreeNode(3);
		root.right.right.right.right.left.right = new TreeNode(3);
		root.right.right.right.right.right = new TreeNode(5); 
		*/
		root.right.left = new TreeNode(2);

		System.out.println(Arrays.toString(findMode(null)));
	}

	private static int[] findMode(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		int count = 1;
		int curMax = 0;
		int curVal;
		int prevVal;

		if (root == null)	return new int[]{};

		while(cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		cur = stack.pop();
		prevVal = cur.val;
		TreeNode it = cur;
		if (it.right != null) {
			it = it.right;
			while (it != null) {
				stack.push(it);
				it = it.left;
			}
		}

		while (!stack.isEmpty()) {
			cur = stack.pop();

			// add new stacks
			TreeNode temp = cur;
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}

			// count
			curVal = cur.val;
			if (prevVal == curVal) {
				System.out.println(curVal);
				count++;
			} else {
				if (count > curMax) {
					res = new ArrayList<>();
					res.add(prevVal);
					curMax = count;
				} else if (count == curMax) {
					res.add(prevVal);
				}

				count = 1;
				prevVal = curVal;
			}
		}

		if (count > curMax) {
			res = new ArrayList<>();
			res.add(prevVal);
		} else if (count == curMax) {
			if (!res.contains(prevVal))
				res.add(prevVal);
		}

		System.out.println(Arrays.toString(res.toArray()));
		
		return res.stream().mapToInt(i -> i).toArray();
	}
}