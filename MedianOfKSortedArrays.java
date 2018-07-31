import java.util.*;

public class MedianOfKSortedArrays {
	public static void main(String[] args) {
		System.out.println(findMedian(new int[][]{{1}, {2}, {3}}));
	}

	private static int max = Integer.MIN_VALUE;
	
	private static double findMedian(int[][] nums) {
		int n = getTotal(nums);
		
		if (n == 0) {
			return 0;
		}

		if (n % 2 == 0) {
			return findKth(nums, n / 2) + findKth(nums, n / 2 + 1);
		}

		return findKth(nums, n / 2 + 1);
	}

	private static int findKth(int[][] nums, int k) {
		int start = 0, end = max;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (countSmallerOrEqual(nums, mid) < k) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (countSmallerOrEqual(nums, start) >= k) {
			return start;
		}

		return end;
	}

	private static int countSmallerOrEqual(int[][] nums, int val) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += countSmallerOrEqual(nums[i], val);
		}

		return sum;
	}

	private static int countSmallerOrEqual(int[] nums, int val) {
		int start = 0, end = nums.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= val) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (nums[start] > val) {
			return start;
		}

		if (nums[end] > val) {
			return end;
		}

		return nums.length;
	}

	private static int getTotal(int[][] nums) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int leng = nums[i].length;
			count += leng;

			if (nums[i][leng - 1] > max) {
				max = nums[i][leng - 1];
			}
		}

		return count;
	}
}