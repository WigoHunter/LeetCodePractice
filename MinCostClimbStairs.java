import java.util.*;

public class MinCostClimbStairs {
    public static void main(String[] args) {
		int[] cost1 = new int[]{10, 15, 20};
		int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

		System.out.println(minCostClimbingStairs(cost1));
		System.out.println(minCostClimbingStairs(cost2));
	}
	
	private static int minCostClimbingStairs(int[] cost) {
		int[][] res = new int[cost.length][2];

		res[0][0] = 0;
		res[0][1] = cost[0];
		res[1][0] = cost[0];
		res[1][1] = cost[1];

		for (int i = 2; i < cost.length; i++) {
			res[i][0] = res[i - 1][1];
			res[i][1] = Math.min(res[i - 2][1], res[i - 1][1]) + cost[i];
		}

		for (int i = 0; i < cost.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}

		return Math.min(res[cost.length - 1][0], res[cost.length - 1][1]);
	}
}