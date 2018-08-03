import java.util.*;

public class MaximumSubarrayIV {
    public static void main(String[] args) {
		int res = maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}, 5);
		System.out.println(res);
	}

	private static int maxSubArray(int[] nums, int k) {
		int n = nums.length;
		if (n < k) {
			return 0;
		}

		int res = 0;
		for (int i = 0; i < k; i++) {
			res += nums[i];
		}

		int min_preSum = 0;
		int[] preSum = new int[n + 1];
		preSum[0] = 0;

		for (int i = 1; i <= n; i++) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
			
			if (i >= k) {
				res = Math.max(res, preSum[i] - min_preSum);
				min_preSum = Math.min(min_preSum, preSum[i - k + 1]);
			}
		}

		return res;
	}
}