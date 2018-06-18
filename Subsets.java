import java.util.*;

public class Subsets {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(subsets(new int[]{1, 2, 3}).toArray()));
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());

		for (int num : nums) {
			int size = res.size();

			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<>(res.get(i));
				temp.add(num);
				res.add(temp);
			}
		}

		return res;
	}
}