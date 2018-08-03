import java.util.*;

public class WallGates {
	private static class Cell {
		int x, y;
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[][] rooms = new int[][] {
			{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
			{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
			{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
		};

		wallsAndGates(rooms);

		for (int i = 0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(rooms[i]));
		}
    }
 
    private static void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					explore(rooms, i, j);
				}
			}
		}
	}

	private static void explore(int[][] rooms, int i, int j) {
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];
		int level = 0;
		Queue<Cell> q = new LinkedList<>();

		if (inBound(rooms, visited, i, j)) {
			q.offer(new Cell(i, j));
		}

		while (!q.isEmpty()) {
			int size = q.size();
			level++;

			for (int k = 0; k < size; k++) {
				Cell cur = q.poll();
				visited[cur.x][cur.y] = true;

				if (level - 1 <= rooms[cur.x][cur.y]) {
					rooms[cur.x][cur.y] = level - 1;			

					if (inBound(rooms, visited, cur.x + 1, cur.y))	q.offer(new Cell(cur.x + 1, cur.y));
					if (inBound(rooms, visited, cur.x - 1, cur.y))	q.offer(new Cell(cur.x - 1, cur.y));
					if (inBound(rooms, visited, cur.x, cur.y + 1))	q.offer(new Cell(cur.x, cur.y + 1));
					if (inBound(rooms, visited, cur.x, cur.y - 1))	q.offer(new Cell(cur.x, cur.y - 1));
				}
			}
		}
	}

	private static boolean inBound(int[][] rooms, boolean[][] visited, int i, int j) {
		return i >= 0 && j >= 0 && i < rooms.length && j < rooms[0].length && !visited[i][j] && rooms[i][j] != -1;
	}
}