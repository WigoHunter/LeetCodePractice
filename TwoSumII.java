import java.util.*;

public class TwoSumII {
    public static void main(String[] args) {
		
    }

	private static int twoSum(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			if (nums[start] + nums[end] > target) {
				end--;
			} else if (nums[start] + nums[end] < target) {
				start++;
			} else {
				return new int[]{start + 1, end + 1};
			}
		}

		return new int[]{};
	} 
}