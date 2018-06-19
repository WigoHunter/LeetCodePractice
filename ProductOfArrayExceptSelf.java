import java.util.*;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
		int[] nums = new int[]{0, 0};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			res[i] = left[i] * right[i];
		}

		return res;
	}
}