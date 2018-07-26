import java.util.*;

public class NumberOfLIS {
	public static void main(String[] args) {
		System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
	}

	private static int findNumberOfLIS(int[] nums) {
		int res = 0, max = 0;
		int[] dp = new int[nums.length];
		int[] count = new int[nums.length];

		Arrays.fill(dp, 1);
		Arrays.fill(count, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
					} else if (dp[j] + 1 == dp[i]) {
						count[i] += count[j];
					}
				}
			}

			if (dp[i] > max) {
				max = dp[i];
				res = count[i];
			} else if (dp[i] == max) {
				res += count[i];
			}
		}

		return res;
	}
}
