import java.util.*;

public class MaximumProductSubarray {
    public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
	}

	private static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)	return 0;
		int max = nums[0], min = nums[0], res = nums[0], temp;

		for (int i = 1; i < nums.length; i++) {
			temp = max;
			max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
			min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
			res = Math.max(max, res);
		}

		return res;
	}	
}