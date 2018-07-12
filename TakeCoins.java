import java.util.*;

public class TakeCoins {
    public static void main(String[] args) {
		System.out.println(takeCoins(new int[]{5, 4, 3, 2, 1}, 2));
	}
	
	private static int takeCoins(int[] list, int k) {
		if (list == null || list.length == 0 || k == 0)	return 0;

		int count = 0;
		if (k >= list.length) {
			for (int num : list) {
				count += num;
			}

			return count;
		}

		for (int i = 0; i < k; i++) {
			count += list[i];
		}

		int max = count;

		for (int i = k - 1, j = 1; i >= 0; i--, j++) {
			count -= list[i];
			count += list[list.length - j];
			max = Math.max(max, count);
		}

		return max;
	}
}