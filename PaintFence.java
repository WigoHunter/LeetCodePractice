import java.util.*;

public class PaintFence {
    public static void main(String[] args) {
		System.out.println(numWays(1, 1));
	}

	private static int numWays(int n, int k) {
		if (n == 0) return 0;
		int same = 0;
		int diff = k;
		int res = same + diff;

		for (int i = 1; i < n; i++) {
			same = diff;
			diff = res * (k - 1);
			res = same + diff;
		}

		return res;
	}
}