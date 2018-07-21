import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
		System.out.println(combinationSum2(new int[]{10, 1, 6, 7, 2, 1, 5}, 8));
	}
	
	private static List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)	return res;
		Arrays.sort(nums);

		helper(nums, 0, new ArrayList<>(), target, res);
		return res;
	}

	private static void helper(int[] nums, int start, List<Integer> list, int target, List<List<Integer>> res) {
		if (target == 0) {
			List<Integer> temp = new ArrayList<>(list);
			if (!res.contains(temp)) {
				res.add(temp);
			}
			return;
		}

		if (target < nums[0]) {
			return;
		}

		for (int i = start; i < nums.length; i++) {
			int newElement = nums[i];
			list.add(newElement);
			helper(nums, i + 1, list, target - newElement, res);
			list.remove(list.size() - 1);
		}
	}
}