import java.util.*;

public class SortColors {
    public static void main(String[] args) {
		int[] nums = new int[]{0, 0, 2, 1, 2, 2};
		sortColors(nums);

		System.out.println(Arrays.toString(nums));
	}

	private static void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		for (int i = 0; i <= right; i++) {
			if (nums[i] == 2) {
				nums[i] = nums[right];
				nums[right] = 2;
				right--;
				i--;
			} else if (nums[i] == 0) {
				nums[i] = nums[left];
				nums[left] = 0;
				left++;
			}
		}
	}
}