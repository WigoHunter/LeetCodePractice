import java.util.*;

public class UniquePathII {
    public static void main(String[] args) {
		int[][] obstacleGrid = new int[][]{
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
		};

		System.out.println(solution(obstacleGrid));
	}

	private static int solution(int[][] obstacleGrid) {
		for (int i = 0; i < obstacleGrid.length; i++) {
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : (i > 0 && obstacleGrid[i - 1][0] == 0 ? 0 : 1);
		}

		for (int i = 1; i < obstacleGrid[0].length; i++) {
			obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : (obstacleGrid[0][i - 1] == 0 ? 0 : 1);
		}

		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				}
			}
		}

		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	// My DFS solution: but doesn't pass the time limit
	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return explore(obstacleGrid, 0, 0);
	}

	private static int explore(int[][] grid, int i, int j) {
		if (i >= grid.length || j >= grid[0].length)	return 0;
		if (grid[i][j] == 1)	return 0;

		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return 1;
		}

		return explore(grid, i + 1, j) + explore(grid, i, j + 1);
	}
}