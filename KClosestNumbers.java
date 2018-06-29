import java.util.*;

public class KClosestNumbers {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(findClosestElements(new int[]{1, 4, 5, 8}, 3, 19).toArray()));
	}

	private static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		if (arr == null || arr.length == 0 || k == 0) {
			return res;
		}

		int index = findIndex(arr, x);
		int low = index;
		int high = index + 1;

		for (int i = 0; i < k; i++) {
			if (high >= arr.length || low >= 0 && Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
				low--;
			} else {
				high++;
			}
		}

		for (int i = 1; i <= k; i++) {
			res.add(arr[low + i]);
		}

		return res;
	}

	private static int findIndex(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int mid;

		while (low < high - 1) {
			mid = (low + high) / 2;

			if (arr[mid] > target) {
				high = mid;
			} else if (arr[mid] < target) {
				low = mid;
			} else {
				return mid;
			}
		}

		if (Math.abs(arr[low] - target) > Math.abs(arr[high] - target)) {
			return high;
		} else {
			return low;
		}
	}
}