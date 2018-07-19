import java.util.*;

public class CountOfSmallerNumAfterSelf {
	private static class TreeNode {
		int val;
		int count = 1;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

    public static void main(String[] args) {
		int[] nums = new int[]{5, 2, 6, 1};
		System.out.println(Arrays.toString(countSmaller(nums).toArray()));
	}
    
    private static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)	return res;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		res.add(0);

		for (int i = nums.length - 2; i >= 0; i--) {
			res.add(insert(root, nums[i]));
		}

		Collections.reverse(res);
		return res;
	}

	private static int insert(TreeNode root, int i) {
		int count = 0;

		while (true) {
			if (i > root.val) {
				count += root.count;

				if (root.right == null) {
					root.right = new TreeNode(i);
					break;
				} else {
					root = root.right;
				}
			} else {
				root.count++;

				if (root.left == null) {
					root.left = new TreeNode(i);
					break;
				} else {
					root = root.left;
				}
			}
		}

		return count;
	}
}