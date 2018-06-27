import java.util.*;

public class HouseRobberII {
    public static void main(String[] args) {
		System.out.println(rob(new int[]{1, 3, 1, 3, 100}));
	}

	private static int rob(int[] nums) {
		if (nums == null || nums.length == 0)   return 0;
        if (nums.length == 1) {
            return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}	

	private static int rob(int[] nums, int low, int high) {
		int temp[] = nums.clone();
		temp[low + 1] = Math.max(temp[low], temp[low + 1]);

		for (int i = low + 2; i < high; i++) {
			temp[i] = Math.max(temp[i - 1], temp[i] + temp[i - 2]);
		}

		System.out.println(Arrays.toString(temp));

		return Math.max(temp[high - 1], temp[high - 2]);
	}
}