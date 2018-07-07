import java.util.*;

public class SearchMatrix {
    public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		};

		System.out.println(searchMatrix(matrix, 3));
		System.out.println(searchMatrix(matrix, 13));
		System.out.println(searchMatrix(matrix, 34));
	}
	
	private static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) 	return false;
		
		int start = 0;
		int end = matrix.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (target > matrix[end][0]) {
			return binarySearch(matrix[end], target);
		}

		return binarySearch(matrix[start], target);
	}

	private static boolean binarySearch(int[] row, int target) {
		int start = 0;
		int end = row.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (row[mid] == target) {
				return true;
			} else if (row[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (row[start] == target || row[end] == target) {
			return true;
		}

		return false;
	}
}