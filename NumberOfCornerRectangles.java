import java.util.*;

public class NumberOfCornerRectangles {
    public static void main(String[] args) {
		int[][] grid = new int[][]{
			{1, 0, 0, 1, 0},
			{0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0},
			{1, 0, 1, 0, 1}
		};

		System.out.println(countCornerRectangles(grid));
		// Solution 1;
	}

	private static int countCornerRectangles(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length <= 1) {
			return 0;
		}

		int count = 0;

		for (int i = 0; i < grid.length - 1; i++) {
			for (int j = i + 1; j < grid.length; j++) {
				int c = 0;

				for (int k = 0; k < grid[0].length; k++) {
					if (grid[i][k] == 1 && grid[j][k] == 1) {
						c++;
					}
				}

				count += c * (c - 1) / 2;
			}
		}

		return count;
	}
}