import java.util.*;

public class CourseSchedule {
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][]{{0, 1}}));
	}

	private static boolean canFinish(int numCourses, int[][] pre) {
		if (numCourses == 0 || pre.length == 0)	return true;
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] pair : pre) {
			graph.get(pair[0]).add(pair[1]);
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (List<Integer> pres : graph.values()) {
			for (int i : pres) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!map.containsKey(i)) {
				q.offer(i);
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			count++;

			for (int i : graph.get(cur)) {
				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					q.offer(i);
				}
			}
		}

		return count == numCourses;
	}
}