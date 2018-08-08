import java.util.*;

public class SeqReconstruction {
	public static void main(String[] args) {
		System.out.println(sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}}));
	}

	private static boolean sequenceReconstruction(int[] org, int[][] seqs) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i : org) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] pair : seqs) {
			graph.get(pair[0]).add(pair[1]);
		}

		Map<Integer, Integer> mapPointToPrev = new HashMap<>();

		for (List<Integer> nexts : graph.values()) {
			for (int i : nexts) {
				mapPointToPrev.put(i, mapPointToPrev.getOrDefault(i, 0) + 1);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i : org) {
			if (!mapPointToPrev.containsKey(i)) {
				q.offer(i);
			}
		}

		int[] res = new int[org.length];
		int count = 0;
		while (!q.isEmpty()) {
			if (q.size() > 1) return false;

			int cur = q.poll();
			res[count] = cur;
			count++;
			
			for (int next : graph.get(cur)) {
				mapPointToPrev.put(next, mapPointToPrev.get(next) - 1);

				if (mapPointToPrev.get(next) == 0) {
					q.offer(next);
				}
			}
		}

		return count == org.length ? equal(res, org) : false;
	}

	private static boolean equal(int[] a, int[] b) {
		if (a == null || b == null)	return false;
		if (a.length != b.length)	return false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])	return false;
		}

		return true;
	}
}