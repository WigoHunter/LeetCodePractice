import java.util.*;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
		System.out.println(search(new int[]{1, 2, 3}, 1));
    }
 
    private static int search(int[] A, int target) {
		if (A == null || A.length == 0)	return -1;
		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;

			/*
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > A[start]) {

			}
			*/

			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > A[start] && target >= A[start] && A[mid] > target) {
				end = mid;
			} else if (A[mid] < A[start] && (target < A[mid] || target > A[start])) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (A[start] == target)	return start;
		if (A[end] == target) return end;
		return -1;
	}
}