import java.util.*;

public class CombinationSumIVI {
    public static void main(String[] args) {
		int[] nums = new int[]{2, 1, 3};
		System.out.println(combinationSum4(nums, 3));
	}
	
	private static int count = 0;

    private static int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		dfs(nums, target);
		return count;
	}

	private static void dfs(int[] nums, int target) {
		if (target == 0) {
			count++;
			return;
		}

		if (target < 0) {
			return;
		}

		for (int num : nums) {
			dfs(nums, target - num);
		}
	}
}