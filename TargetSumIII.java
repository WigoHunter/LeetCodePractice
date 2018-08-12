import java.util.*;

public class TargetSumIII {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, 0, 1, S) + dfs(nums, 0, 0, -1, S);
    }

    private static int dfs(int[] nums, int index, int cur, int negative, int S) {
		if (index == nums.length - 1) {
			if (cur + negative * nums[index] == S)
				return 1;
			else
				return 0;
		}

		return dfs(nums, index + 1, cur + negative * nums[index], 1, S) + dfs(nums, index + 1, cur + negative * nums[index], -1, S);
    }
}