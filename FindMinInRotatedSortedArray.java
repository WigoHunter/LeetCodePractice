import java.util.*;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
		System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
		System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
	}

	private static int findMin(int[] nums) {
		if (nums == null || nums.length == 0)	return -1;
		if (nums.length == 1)	return nums[0];

		int low = 0;
		int high = nums.length - 1;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;
			
			if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			} else if (nums[mid] > nums[low] && nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return nums[low];
	}
}