import java.util.*;

public class MinSwapsForIncreasingSequence {
    public static void main(String[] args) {
		System.out.println(minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
	}

	private static int minSwap(int[] A, int[] B) {
		int[][] dp = new int[A.length][2];

		dp[0][0] = 0;
		dp[0][1] = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
					int min = Math.min(dp[i - 1][0], dp[i - 1][1]);
					dp[i][0] = min;
					dp[i][1] = min + 1;
				} else {
					dp[i][0] = dp[i - 1][0];
					dp[i][1] = dp[i - 1][1] + 1;
				}
			} else {
				dp[i][0] = dp[i - 1][1];
				dp[i][1] = dp[i - 1][0] + 1;
			}
		}

		return Math.min(dp[A.length - 1][0], dp[A.length - 1][1]);
	}
}