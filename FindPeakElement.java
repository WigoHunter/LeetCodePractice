import java.util.*;

public class FindPeakElement {
    public static void main(String[] args) {
		System.out.println(findPeak(new int[]{ 1,2,1,3,4,5,7,6 }));
	}

	private static int findPeak(int[] A) {
		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			} else if (A[mid] > A[mid - 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return A[start] > A[end] ? start : end;
	}
}