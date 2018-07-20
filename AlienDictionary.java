import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
		System.out.println(alienOrder(new String[]{"zy", "zx"}));
	}
	
	private static String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = buildMap(words);
		return topologicalSorting(graph);
	}

	private static String topologicalSorting(Map<Character, Set<Character>> graph) {
		Map<Character, Integer> incoming = new HashMap<>();

		for (Character c : graph.keySet()) {
			incoming.put(c, 0);
		}

		for (Set<Character> set : graph.values()) {
			for (Character c : set) {
				incoming.put(c, incoming.get(c) + 1);
			}
		}

		Queue<Character> q = new LinkedList<>();
		for (Map.Entry<Character, Integer> e : incoming.entrySet()) {
			if (e.getValue() == 0) {
				q.offer(e.getKey());
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			Character c = q.poll();
			sb.append(c);

			for (Character next : graph.get(c)) {
				incoming.put(next, incoming.get(next) - 1);
				if (incoming.get(next) == 0) {
					q.offer(next);
				}
			}
		}

		if (sb.length() != incoming.size()) return "";

		return sb.toString();
	}

	private static Map<Character, Set<Character>> buildMap(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char c = words[i].charAt(j);
				if (!map.containsKey(c)) {
					map.put(c, new HashSet<Character>());
				}
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			int index = 0;

			while (index < words[i].length() && index < words[i + 1].length()) {
				if (words[i].charAt(index) != words[i + 1].charAt(index)) {
					map.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
					break;
				}

				index++;
			}
		}

		return map;
	}
}