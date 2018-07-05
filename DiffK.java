import java.util.*;

public class DiffK {
    public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.addAll(Arrays.asList(1, 3, 5));

		System.out.println(diffPossible(nums, 4));
	}
	
	private static int diffPossible(ArrayList<Integer> nums, int target) {
		Set<Integer> set = new HashSet<>();
		int[] tar = new int[2];

		for (int i : nums) {
			tar[0] = i - target;
			tar[1] = target + i;

			if (set.contains(tar[0]) || set.contains(tar[1])) {
				return 1;
			}

			set.add(i);
		}

		return 0;
	}
}