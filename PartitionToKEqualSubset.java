import java.util.*;

public class PartitionToKEqualSubset {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    private static boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return false;
		}

		int sum = 0;

		for (int num : nums) {
			sum += num;
		}

		if (sum % k != 0) {
			return false;
		}

		boolean[] visited = new boolean[nums.length];

		return canPartition(nums, visited, 0, 0, sum / k, k);
	}

	private static boolean canPartition(int[] nums, boolean[] visited, int start, int sum, int target, int count) {
		if (count == 0) return true;
		if (sum == target) return canPartition(nums, visited, 0, 0, target, count - 1);

		for (int i = start; i < nums.length; i++) {
			if (!visited[i] && sum + nums[i] <= target) {
				visited[i] = true;
				if (canPartition(nums, visited, start + 1, sum + nums[i], target, count)) {
					return true;
				}
				visited[i] = false;
			}
		}

		return false;
	}
}