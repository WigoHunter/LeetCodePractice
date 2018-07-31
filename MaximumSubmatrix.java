import java.util.*;

public class MaximumSubmatrix {
	public static void main(String[] args) {
		System.out.println(maxSubmatrix(new int[][]{
			{1, 3, -1},
			{2, 3, -2},
			{-1, -2, -3}
		}));
	}
	
	private static int maxSubmatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] sum = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				sum[i][j] = sum[i - 1][j] + matrix[i - 1][j - 1];
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= m; i++) {
			for (int j = i + 1; j <= m; j++) {
				int cur = 0;

				for (int k = 1; k <= n; k++) {
					cur += sum[j][k] - sum[i][k];
					if (cur > max) {
						max = cur;
					}

					if (cur < 0) {
						cur = 0;
					}
				}
			}
		}

		return max;
	}
}