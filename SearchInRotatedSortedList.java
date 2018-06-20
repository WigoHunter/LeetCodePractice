import java.util.*;

public class SearchInRotatedSortedList {
    public static void main(String[] args) {
		int[] nums = new int[]{3, 1};

		System.out.println(search(nums, 3));
	}

	private static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length;

		while (left < right) {
			int mid = (left + right) / 2;
			int midValue = nums[mid] < nums[0] == target < nums[0]
				? nums[mid]
				: target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	
			if (midValue > target) {
				right = mid;
			} else if (midValue < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}