import java.util.*;

public class PoliceDistance {
	private static class Cell {
		int x, y, dist;
		Cell (int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

    public static void main(String[] args) {
		int[][] res = policeDistance(new int[][] {
			{0, -1, -1},
			{0, -1, 1},
			{0, 0, 0}
		});

		for (int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
    }
 
    private static int[][] policeDistance(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < res.length; i++) {
			Arrays.fill(res[i], 0);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0)
					res = explore(matrix, i, j, res);
				else if (matrix[i][j] == 1) {
					res[i][j] = 0;
				} else {
					res[i][j] = matrix[i][j];
				}
			}
		}

		return res;
	}

	private static int[][] explore(int[][] matrix, int i, int j, int[][] res) {
		int level = 1;
		Queue<Cell> q = new LinkedList<>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int k = 0; k < visited.length; k++) {
			Arrays.fill(visited[k], false);
		}

		if (i > 0) q.add(new Cell(i - 1, j, level));
		if (j > 0) q.add(new Cell(i, j - 1, level));
		if (i < matrix.length - 1)	q.add(new Cell(i + 1, j, level));
		if (j < matrix[0].length - 1)	q.add(new Cell(i, j + 1, level));

		while (!q.isEmpty()) {
			level++;
			int curSize = q.size();

			for (int k = 0; k < curSize; k++) {
				Cell cur = q.poll();
				if (matrix[cur.x][cur.y] == 1) {
					res[i][j] = cur.dist;
					return res;
				} else if (matrix[cur.x][cur.y] != -1 && !visited[cur.x][cur.y]) {
					int curI = cur.x;
					int curJ = cur.y;
					visited[curI][curJ] = true;
					
					if (curI > 0)	q.add(new Cell(curI - 1, curJ, level));
					if (curJ > 0)	q.add(new Cell(curI, curJ - 1, level));
					if (curI < matrix.length - 1)	q.add(new Cell(curI + 1, curJ, level));
					if (curJ < matrix[0].length - 1)	q.add(new Cell(curI, curJ + 1, level));
				}
			}
		}

		return res;
	}
}