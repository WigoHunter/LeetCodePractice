import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 1, 2, 2, 3};
		System.out.println(removeDuplicates(nums));
	}

	private static int removeDuplicates(int[] nums) {
		if (nums.length < 3)	return nums.length;
		int left = 1;
		boolean safe = true;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				safe = true;
				nums[left] = nums[i];
				left++;
			} else {
				if (safe) {
					nums[left] = nums[i];
					left++;
					safe = false;
				}
			}
		}

		System.out.println(Arrays.toString(nums));
		return left;
	}
}