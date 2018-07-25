import java.util.*;

public class CourseScheduleIIP {
	public static void main(String[] args) {
		int[] res = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
		System.out.println(Arrays.toString(res));
	}

	private static int[] findOrder(int numCourses, int[][] pre) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] pair : pre) {
			map.get(pair[1]).add(pair[0]);
		}

		Map<Integer, Integer> incomings = new HashMap<>();
		for (List<Integer> nexts : map.values()) {
			for (int i : nexts) {
				incomings.put(i, incomings.getOrDefault(i, 0) + 1);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!incomings.containsKey(i)) {
				q.offer(i);
			}
		}

		int[] res = new int[numCourses];
		int index = 0;
		while (!q.isEmpty()) {
			int course = q.poll();
			res[index] = course;
			index++;

			for (int next : map.get(course)) {
				incomings.put(next, incomings.get(next) - 1);

				if (incomings.get(next) == 0) {
					q.offer(next);
				}
			}
		}

		return index == numCourses ? res : new int[]{} ;
	}
}