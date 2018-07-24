import java.util.*;

public class Permutations {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(permute(new int[]{1, 2, 3}).toArray()));
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> possibles = new ArrayList<>();

		Arrays.sort(nums);
		for (int i : nums) {
			possibles.add(i);
		}

		helper(possibles, new ArrayList<>(), res);
		return res;
	}

	private static void helper(List<Integer> possibles, List<Integer> list, List<List<Integer>> res) {
		if (possibles.isEmpty()) {
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < possibles.size(); i++) {
			if (i > 0 && possibles.get(i) == possibles.get(i - 1))	continue;

			int num = possibles.get(i);
			list.add(num);
			possibles.remove(i);
			helper(possibles, list, res);
			possibles.add(i, num);
			list.remove(list.size() - 1);
		}
	}
}