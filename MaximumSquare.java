import java.util.*;

public class MaximumSquare {
    public static void main(String[] args) {
		char[][] matrix = new char[][] {
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '0', '0'}
		};

		System.out.println(maximalSquare(matrix));
    }
 
	private static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)	return 0;

		int max = 0;
		int[][] squares = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					squares[i][j] = Math.min(Math.min(squares[i - 1][j - 1], squares[i - 1][j]), squares[i][j - 1]) + 1;
					if (squares[i][j] > max) {
						max = squares[i][j];
					}
				}
			}
		}

		for (int i = 0; i < squares.length; i++) {
			System.out.println(Arrays.toString(squares[i]));
		}

		return max * max;
	}
}