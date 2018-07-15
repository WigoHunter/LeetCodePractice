import java.util.*;

public class SequenceReconstruction {
	public static void main(String[] args) {
		System.out.println(sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {2, 3}, {1, 3}}));
	}

	private static boolean sequenceReconstruction(int[] org, int[][] seqs) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i : org) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] pair : seqs) {
			for (int i = 0; i < pair.length - 1; i++) {
				graph.get(pair[i]).add(pair[i + 1]);
			}
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
			int size = q.size();
			if (size > 1)	return false;
			
			int cur = q.poll();
			res[count] = cur;
			count++;

			for (int i : graph.get(cur)) {
				mapPointToPrev.put(i, mapPointToPrev.get(i) - 1);
				if (mapPointToPrev.get(i) == 0) {
					q.offer(i);
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