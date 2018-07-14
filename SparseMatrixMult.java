import java.util.*;

public class SparseMatrixMult {
	public static void main(String[] args) {
		int[][] A = new int[][] {
			{1, 0, 0},
			{-1, 0, 3},
		};

		int[][] B = new int[][] {
			{7, 0, 0},
			{0, 0, 0},
			{0, 0, 1}
		};

		int[][] C = multiply(A, B);
		for (int i = 0; i < C.length; i++) {
			System.out.println(Arrays.toString(C[i]));
		}
	}

	private static int[][] multiply(int[][] A, int[][] B) {
		int[][] res = new int[A.length][B[0].length];

		List<List<Integer>> cols = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			List<Integer> col = new ArrayList<>();

			for (int j = 0; j < B[0].length; j++) {
				if (B[i][j] != 0) {
					col.add(j);
				}
			}

			cols.add(col);
		}

		for (int i = 0; i < A.length; i++) {
			for (int k = 0; k < A[0].length; k++) {
				if (A[i][k] == 0) continue;

				for (int j : cols.get(k)) {
					res[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		return res;
	}
}