import java.util.*;

public class CourseScheduleII {
	public static void main(String[] args) {
		int[] res = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
		System.out.println(Arrays.toString(res));
	}

	private static int[] findOrder(int numCourses, int[][] pre) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] pair : pre) {
			graph.get(pair[1]).add(pair[0]);
		}

		Map<Integer, Integer> mapCourseToPrereq = new HashMap<>();
		for (List<Integer> nexts : graph.values()) {
			for (int i : nexts) {
				mapCourseToPrereq.put(i, mapCourseToPrereq.getOrDefault(i, 0) + 1);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!mapCourseToPrereq.containsKey(i)) {
				q.offer(i);
			}
		}

		int[] res = new int[numCourses];
		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			res[count] = cur;
			count++;

			for (int i : graph.get(cur)) {
				mapCourseToPrereq.put(i, mapCourseToPrereq.get(i) - 1);

				if (mapCourseToPrereq.get(i) == 0) {
					q.offer(i);
				}
			}
		}

		if (count == numCourses)
			return res;

		return new int[]{};
	}
}