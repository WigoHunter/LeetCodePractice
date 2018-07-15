import java.util.*;

public class KnightShortestPath {
	private static class Point {
		int x, y;
		Point() { x = 0; y = 0; }
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		boolean[][] grid = new boolean[][]{
			{false, true, false},
			{false, false, false},
			{false, false, false}
		};

		System.out.println(shortestPath(grid, new Point(2, 0), new Point(2, 2)));
	}

	private static int shortestPath(boolean[][] grid, Point source, Point destination) {
		int level = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(source);

		int[] stepX = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
		int[] stepY = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

		while (!q.isEmpty()) {
			int size = q.size();

			for (int j = 0; j < size; j++) {
				Point cur = q.poll();
				if (cur.x == destination.x && cur.y == destination.y) {
					return level;
				}
	
				for (int i = 0; i < stepX.length; i++) {
					int x = cur.x + stepX[i];
					int y = cur.y + stepY[i];
	
					if (valid(grid, x, y)) {
						grid[x][y] = true;
						q.offer(new Point(x, y));
					}
				}
			}

			level++;
		}

		return -1;
	}

	private static boolean valid(boolean[][] grid, int x, int y) {
		if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y])	return false;

		return true;
	}
}