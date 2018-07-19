import java.util.*;

public class CombinationSumIV {
    public static void main(String[] args) {
		int[] nums = new int[]{9};
		System.out.println(combinationSum4(nums, 3));
	}
    
    private static int combinationSum4(int[] nums, int target) {
		int[] res = new int[target + 1];
		res[0] = 0;
		for (int num : nums) {
			if (num <= target)
				res[num]++;
		}

		for (int i = 1; i <= target; i++) {
			int count = res[i];
			for (int num : nums) {
				if (i - num > 0) {
					count += res[i - num];
				}
			}

			res[i] = count;
		}

		return res[target];
	}
}