import java.util.*;

public class WordLadderII {
   	public static void main(String[] args) {
		Set<String> dict = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		System.out.println(Arrays.toString(findLadders("hit", "cog", dict).toArray()));
	}
	
	private static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		dict.add(start);
		dict.add(end);

		bfs(map, distance, end, start, dict);
		dfs(res, new ArrayList<>(), start, end, distance, map);

		return res;
	}

	private static void dfs(List<List<String>> res, List<String> path, String cur, String end, Map<String, Integer> distance, Map<String, List<String>> map) {
		path.add(cur);
		if (cur.equals(end)) {
			res.add(new ArrayList<>(path));
		} else {
			for (String next : map.get(cur)) {
				if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
					dfs(res, path, next, end, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}

	private static void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		distance.put(start, 0);
	
		for (String s : dict) {
			map.put(s, new ArrayList<>());
		}

		while (!q.isEmpty()) {
			String cur = q.poll();
			List<String> nextList = expand(cur, dict);
			map.get(cur).addAll(nextList);

			for (String next : nextList) {
				if (!distance.containsKey(next)) {
					distance.put(next, distance.get(cur) + 1);
					q.offer(next);
				}
			}
		}
	}

	private static List<String> expand(String cur, Set<String> dict) {
		List<String> expand = new ArrayList<>();

		for (int i = 0; i < cur.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != cur.charAt(i)) {
					String expanded = cur.substring(0, i) + c + cur.substring(i + 1);
					if (dict.contains(expanded)) {
						expand.add(expanded);
					}
				}
			}
		}

		return expand;
	}
}