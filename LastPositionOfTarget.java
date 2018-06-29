import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class LastPositionOfTarget {
    public static void main(String[] args) {
		System.out.println(lastPosition(new int[]{
			1, 2, 2, 4, 5, 5
		}, 6));
	}

	private static int lastPosition(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid;

		while (low <= high) {
			while (low + 1 < nums.length && nums[low] == nums[low + 1])	low++;
			
			mid = (low + high) / 2;
			if (target > nums[mid]) {
				low = mid + 1;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				while (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) mid++;
				return mid;
			}
		}

		return -1;
	}
}