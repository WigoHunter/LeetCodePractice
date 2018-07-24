import java.util.*;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
 
	private static int maxProfit(int[] prices, int fee) {
		if (prices.length < 2)	return 0;

		int[][] maxProfits =  new int[prices.length][2];
		maxProfits[0][0] = 0;
		maxProfits[0][1] = -prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			maxProfits[i][0] = Math.max(maxProfits[i - 1][0], maxProfits[i - 1][1] + prices[i] - fee);
			maxProfits[i][1] = Math.max(maxProfits[i - 1][1], maxProfits[i - 1][0] - prices[i]);
		}

		return Math.max(maxProfits[prices.length - 1][0], maxProfits[prices.length - 1][1]);
	}
}