import java.util.*;

public class RussianDollEnvelopes {
	public static void main(String[] args) {
		System.out.println(maxEnvelopes(new int[][]{
			{5, 4},
			{6, 4},
			{6, 7},
			{2, 3}
		}));
	}

	private static int maxEnvelopes(int[][] e) {
		if (e == null || e.length == 0)	return 0;

		Arrays.sort(e, ((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

		int[] dp = new int[e.length];
		int max = 0;

		for (int i = 0; i < e.length; i++) {
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (e[i][0] > e[j][0] && e[i][1] > e[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			max = Math.max(max, dp[i]);
		}

		return max;
	}
}