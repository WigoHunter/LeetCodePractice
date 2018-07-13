import java.util.*;

public class WallsAndGates {
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
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					explore(rooms, i, j, visited);
				}
			}
		}
	}

	private static void explore(int[][] rooms, int i, int j, boolean[][] visited) {
		Queue<Cell> q = new LinkedList<>();
		int level = 0;
		for (int k = 0; k < visited.length; k++) {
			Arrays.fill(visited[k], false);
		}

		q.add(new Cell(i, j));

		while (!q.isEmpty()) {
			int curSize = q.size(); 
			level++;

			for (int k = 0; k < curSize; k++) {
				Cell cur = q.poll();

				if (!visited[cur.x][cur.y]) {
					int status = rooms[cur.x][cur.y];
					if (status != -1) {
						if (cur.x > 0) q.add(new Cell(cur.x - 1, cur.y));
						if (cur.y > 0) q.add(new Cell(cur.x, cur.y - 1));
						if (cur.x < rooms.length - 1) q.add(new Cell(cur.x + 1, cur.y));
						if (cur.y < rooms[0].length - 1) q.add(new Cell(cur.x, cur.y + 1));
					}
	
					if (status > 0) {
						if (level < status) {
							rooms[cur.x][cur.y] = level - 1;
						}
					}

					visited[cur.x][cur.y] = true;
				}				
			}
		}
	}
}