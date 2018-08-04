import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(largestDivisibleSubset(new int[]{1, 2, 3, 8}).toArray()));
	}

	private static List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}

		Arrays.sort(nums);

		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] dp = new int[nums.length];
		int maxIndex = 0;
		int maxCount = 0;

		for (int i = 0; i < nums.length; i++) {
			map.put(i, new ArrayList<>());

			int preIndex = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						preIndex = j;
					}
				}
			}

			if (dp[i] != 0) {
				map.get(i).addAll(map.get(preIndex));
			}

			map.get(i).add(nums[i]);

			if (dp[i] > maxCount) {
				maxCount = dp[i];
				maxIndex = i;
			}
		}

		return map.get(maxIndex);
	}
}