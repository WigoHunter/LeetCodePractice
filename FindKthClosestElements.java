import java.util.*;

public class FindKthClosestElements {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(findClosestElements(new int[]{1,2,4,5,6,7,8,10}, 5, 0)));
	}

	private static int[] findClosestElements(int[] A, int target, int k) {
		if (A == null || A.length == 0 || k == 0)	return new int[]{};
		int index = findIndex(A, target);
		int[] res = new int[k];
		int i = 1;
		int l = index - 1;
		int r = index + 1;
		res[0] = A[index];

		while (i < k) {
			if (l < 0) {
				res[i] = A[r];
				r++;
			} else if (r >= A.length) {
				res[i] = A[l];
				l--;
			} else {
				if (Math.abs(A[l] - target) > Math.abs(A[r] - target)) {
					res[i] = A[r];
					r++;
				} else {
					res[i] = A[l];
					l--;
				}
			}

			i++;
		}

		return res;
	}

	private static int findIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid;

		while (low < high - 1) {
			mid = (low + high) / 2;
			
			if (nums[mid] > target) {
				high = mid;
			} else if (nums[mid] < target) {
				low = mid;
			} else {
				return mid;
			}
		}

		if (Math.abs(nums[low] - target) > Math.abs(nums[high] - target)) {
			return high;
		} else {
			return low;
		}
	}
}