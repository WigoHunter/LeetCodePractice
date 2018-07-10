import java.util.*;

public class LIS {
   	public static void main(String[] args) {
		System.out.println(findLengthOfLIS(new int[]{1, 3, 5, 4, 7}));
	}
	
	private static int findLengthOfLIS(int[] nums) {
		int res = 0, max = 0;
		int[] dp = new int[nums.length];
		int[] counts = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.fill(counts, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						counts[i] = counts[j];
					} else if (dp[j] + 1 == dp[i]) {
						counts[i] += counts[j];
					}
				}
			}

			if (max == dp[i]) {
				res += counts[i];
			} else if (max < dp[i]) {
				max = dp[i];
				res = counts[i];
			}
		}

		return res;
	}
}