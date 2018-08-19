import java.util.*;

public class GoogleFruitOA {
    public static void main(String[] args) {
		int nums[] = new int[]{1, 2, 3, 1};
		System.out.println(fruits(nums));	// return 4
	}

	private static int fruits(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return 1;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int start = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

			while (map.size() > 2) {
				map.put(nums[start], map.get(nums[start]) - 1);
				if (map.get(nums[start]) == 0) {
					map.remove(nums[start]);
				}

				start++;
			}

			while (map.size() < 2) {
				i++;
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			}

			max = Math.max(max, i - start + 1);
		}

		return max;
	}
}