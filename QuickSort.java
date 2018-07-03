import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 1, 4, 5, 0};
		quickSort(nums);

		System.out.println(Arrays.toString(nums));
    }

	private static void quickSort(int[] nums) {
		qs(nums, 0, nums.length - 1);
	}

	private static void qs(int[] A, int start, int end) {
		if (start >= end) {
			return;
		}

		int left = start;
		int right = end;
		int pivot = A[(start + end) / 2];

		while (left <= right) {
			while (left <= right && A[left] < pivot) {
				left++;
			}
			while (left <= right && A[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				
				left++;
				right--;
			}
		}

		qs(A, start, right);
		qs(A, left, end);
	}
}