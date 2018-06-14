import java.util.*;

public class BestTimeStock {
    public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
 
	private static int maxProfit(int[] prices) {
		if (prices.length == 0)	return 0;

		int curMaxProfit = 0;
		int curPrice = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > curPrice) {
				curMaxProfit = Math.max(curMaxProfit, prices[i] - curPrice);
			} else {
				curPrice = prices[i];
			}
		}

		return curMaxProfit;
	}
}