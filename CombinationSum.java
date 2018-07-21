import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
	}
	
	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0)	return res;
		Arrays.sort(candidates);

		helper(candidates, 0, new ArrayList<>(), target, res);
		return res;
	}

	private static void helper(int[] candidates, int start, List<Integer> list, int target, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		if (target < candidates[0]) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			int newElement = candidates[i];
			list.add(newElement);
			helper(candidates, i, list, target - newElement, res);
			list.remove(list.size() - 1);
		}
	}
}