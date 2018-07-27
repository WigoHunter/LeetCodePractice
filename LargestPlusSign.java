import java.util.*;

public class LargestPlusSign {
	public static void main(String[] args) {
		System.out.println(orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
	}

	private static int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] grid = new int[N][N];
		int count;

		for (int i = 0; i < N; i++) {
			Arrays.fill(grid[i], 1);
		}

		for (int[] mine : mines) {
			grid[mine[0]][mine[1]] = 0;
		}

		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if (grid[i][j] != 0) {
					count++;
				} else {
					count = 0;
				}

				grid[i][j] = count;
			}

			count = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (grid[i][j] != 0) {
					count++;
				} else {
					count = 0;
				}

				grid[i][j] = Math.min(grid[i][j], count);
			}
		}

		int max = 0;
		for (int j = 0; j < N; j++) {
			count = 0;
			for (int i = 0; i < N; i++) {
				if (grid[i][j] != 0) {
					count++;
				} else {
					count = 0;
				}

				grid[i][j] = Math.min(grid[i][j], count);
			}
			
			count = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (grid[i][j] != 0) {
					count++;
				} else {
					count = 0;
				}

				grid[i][j] = Math.min(grid[i][j], count);
				max = Math.max(max, grid[i][j]);
			}
		}

		return max;
	}
}
