import java.util.*;

public class NumberOfIslands {

    public static void main(String[] args) {
		System.out.println(_numIslands(new char[][] {
			{'1', '1', '1', '1', '0'},
			{'1', '1', '0', '1', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '0', '0'}
		}));
    }
 
    private static int _numIslands(char[][] grid) {
		int count = 0;

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					explore(grid, i, j);
				}
			}
		}

		return count;
	}

	private static void explore(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}

		if (grid[i][j] == '1') {
			grid[i][j] = 0;
			explore(grid, i + 1, j);
			explore(grid, i - 1, j);
			explore(grid, i, j + 1);
			explore(grid, i, j - 1);
		}
	}
}