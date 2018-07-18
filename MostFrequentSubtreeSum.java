import java.util.*;

public class MostFrequentSubtreeSum {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private static int maxFrequency = 0;
	private static List<Integer> sums = new ArrayList<>();
	private static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		System.out.println(Arrays.toString(findFrequentTreeSum(root)));
    }
 
    private static int[] findFrequentTreeSum(TreeNode root) {
		findSum(root);
		return sums.stream().mapToInt(i -> i).toArray();
	}

	private static int findSum(TreeNode root) {
		if (root == null)	return 0;

		int sum = findSum(root.left) + findSum(root.right) + root.val;

		map.put(sum, map.getOrDefault(sum, 0) + 1);
		if (map.get(sum) > maxFrequency) {
			maxFrequency = map.get(sum);
			sums = new ArrayList<>();
			sums.add(sum);
		} else if (map.get(sum) == maxFrequency) {
			sums.add(sum);
		}

		return sum;
	}
}