import java.util.*;

public class BestTimeStockWithCD {
    public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
 
	private static int maxProfit(int[] prices) {
		if (prices.length < 2)	return 0;

		int[][] maxProfits =  new int[prices.length][2];
		maxProfits[0][0] = 0;
		maxProfits[0][1] = -prices[0];
		maxProfits[1][0] = Math.max(0, prices[1] - prices[0]);
		maxProfits[1][1] = Math.max(-prices[1], -prices[0]);

		for (int i = 2; i < prices.length; i++) {
			maxProfits[i][0] = Math.max(maxProfits[i - 1][0], maxProfits[i - 1][1] + prices[i]);
			maxProfits[i][1] = Math.max(maxProfits[i - 1][1], maxProfits[i - 2][0] - prices[i]);
		}

		return maxProfits[prices.length - 1][0];
	}
}