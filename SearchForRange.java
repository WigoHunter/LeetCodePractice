import java.util.*;

public class SearchForRange {

    public static void main(String[] args) {
		System.out.println(Arrays.toString(_searchForRange(new int[]{1, 4}, 4)));
    }
 
    private static int[] _searchForRange(int[] nums, int target) {
		int pos = findTarget(nums, target);
		int low = pos;
		int high = pos;

		if (pos == -1) {
			return new int[]{-1, -1};
		} else {
			while (low >= 0 && nums[low] == target) {
				low--;
			}

			while (high < nums.length && nums[high] == target) {
				high++;
			}
		}

		return new int[]{low + 1, high - 1};
	}

	private static int findTarget(int[] nums, int target) {
		if (nums.length == 1 && nums[0] == target) return 0;

		int start = 0;
		int end = nums.length - 1;
		int mid;

		while (end >= start) {
			mid = start + (end - start) / 2;

			if(nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	// Start : Find first greater than or equal to target
	// End: Then find first greater than or equal to target + 1
	/*
	private static int[] solution(int[] nums, int target) {
		int start = firstGreaterEqual(nums, target);

		if (start == nums.length || nums[start] != target) {
			return new int[]{-1, -1};
		}

		return new int[]{start, firstGreaterEqual(nums, target + 1)};
	}

	private static int firstGreaterEqual(int[] nums, int target) {
		int low = 0;
		int high = nums.length;

		while (low < high) {
			int mid = low + ((high - low) >> 1);

			if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return low;
	}
	*/
}