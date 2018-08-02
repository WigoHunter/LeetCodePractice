import java.util.*;

public class MaximumSubarray {
    public static void main(String[] args) {
		int res = maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3});
		System.out.println(res);
	}

	private static int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		
		return max;
	}
}