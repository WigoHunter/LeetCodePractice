import java.util.*;

public class PerfectSquares {
    public static void main(String[] args) {
		System.out.println(numSquares(12));
	}

	private static int numSquares(int n) {
		int[] res = new int[n + 1];
		res[0] = 0;

		for (int i = 1; i <= n; i++) {
			res[i] = Integer.MAX_VALUE;
			int counter = 1;

			for (int j = 1; j <= i; j += counter) {
				res[i] = Math.min(res[i], res[i - j] + 1);
				counter += 2;
			}
		}

		return res[n];
	}
}