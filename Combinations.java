import java.util.*;

public class Combinations {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(combine(4, 2).toArray()));
	}
	
	private static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n == 0 || k == 0 || k > n)	return res;

		combine(n, 1, k, new ArrayList<>(), res);
		return res;
	}

	private static void combine(int n, int start, int k, List<Integer> list, List<List<Integer>> res) {
		if (k == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		if (start > n) {
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);

			if (k > 0) {
				combine(n, i + 1, k - 1, list, res);
			}

			list.remove(list.size() - 1);
		}
	}
}