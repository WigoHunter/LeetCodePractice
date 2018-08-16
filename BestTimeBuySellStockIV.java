import java.util.*;

public class BestTimeBuySellStockIV {
    public static void main(String[] args) {
        System.out.println(maxProfit(1, new int[]{1, 2}));
    }

    private static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }
		
		int allows = k * 2;
        int[] state = new int[allows];
        Arrays.fill(state, Integer.MIN_VALUE);
        state[0] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
			state[0] = Math.max(state[0], -prices[i]);
			System.out.println(state[0]);
			
            for (int j = 1; j < allows; j++) {
                if (j % 2 == 1) {
					state[j] = Math.max(state[j], state[j - 1] + prices[i]);
                } else {
					state[j] = Math.max(state[j], state[j - 1] - prices[i]);
                }
            }
        }
        
        return Math.max(0, state[allows - 1]);
    }
}