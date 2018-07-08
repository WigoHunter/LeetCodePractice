import java.util.*;

public class BombEnemy {
    public static void main(String[] args) {
		char[][] grid = new char[][]{
			{'0', 'E', '0', '0'},
			{'E', '0', 'W', 'E'},
			{'0', 'E', '0', '0'}
		};

		System.out.println(maxKilledEnemies(grid));
	}
	
	private static int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		int row = 0;
		int[] col = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0 || grid[i][j - 1] == 'W') {
					row = 0;
					for (int k = j; k < n && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E') {
							row++;
						}
					}
				}

				if (i == 0 || grid[i - 1][j] == 'W') {
					col[j] = 0;
					for (int k = i; k < m && grid[k][j] != 'W'; k++) {
						if (grid[k][j] == 'E') {
							col[j]++;
						}
					}
				}

				if (grid[i][j] == '0')
					res = Math.max(res, row + col[j]);
			}
		}

		return res;
	}
}