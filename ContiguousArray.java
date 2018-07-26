import java.util.*;

public class ContiguousArray {
	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[]{0, 1, 0}));
	}

	private static int findMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)	return 0;

        for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)	nums[i] = -1;
		}

		Map<Integer, Integer> mapSumToFirstIndex = new HashMap<>();
		mapSumToFirstIndex.put(0, -1);
		int sum = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (mapSumToFirstIndex.containsKey(sum)) {
				max = Math.max(max, i - mapSumToFirstIndex.get(sum));
			} else {
				mapSumToFirstIndex.put(sum, i);
			}
		}

		return max;
	}
}
