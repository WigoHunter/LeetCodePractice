import java.util.*;

public class CombinationSumIII {
    public static void main(String[] args) {
		System.out.println(combinationSum3(3, 9));
	}
	
	private static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		int[] possibles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

		dfs(new ArrayList<>(), k, n, possibles, 0, res);

		return res;
	}

	private static void dfs(List<Integer> list, int nums, int target, int[] possibles, int start, List<List<Integer>> res) {
		if (nums == 0 && target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		if (target <= 0) {
			return;
		}

		for (int i = start; i < possibles.length; i++) {
			list.add(possibles[i]);
			dfs(list, nums - 1, target - possibles[i], possibles, i + 1, res);
			list.remove(list.size() - 1);
		}
	}
}