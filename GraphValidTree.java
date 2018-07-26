import java.util.*;

public class GraphValidTree {
	public static void main(String[] args) {
		System.out.println(validTree(5, new int[][]{
			{0, 1},
			{0, 2},
			{0, 3},
			{1, 4}
		}));
	}

	private static boolean validTree(int n, int[][] edges) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] pair : edges) {
			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}

		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (visited[cur]) {
				return false;
			}

			visited[cur] = true;
			for (int i : map.get(cur)) {
				if (!visited[i]) q.offer(i);
			}
		}

		for (boolean b : visited) {
			if (!b)	return false;
		}

		return true;
	}
}
