import java.util.*;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }

    private static boolean canPartition(int[] nums) {
		if (nums == null || nums.length < 2) {
			return false;
		}

		int sum = 0;

		for (int num : nums) {
			sum += num;
		}

		if (sum % 2 == 1) {
			return false;
		}

		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int num : nums) {
			for (int i = sum; i >= 0; i--) {
				if (i >= num)
					dp[i] = dp[i] || dp[i - num];
			}
		}

		return dp[sum];
    }
}