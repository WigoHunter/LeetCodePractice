import java.util.*;

public class ShortestValidPangram {
    public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		set.addAll(Arrays.asList('a', 'b', 'c'));
		System.out.println(shortestValidPangram(set, "baabbcab"));
	}

	private static String shortestValidPangram(Set<Character> set, String s) {
		if (set == null || s == null || set.size() > s.length()) {
			return null;
		}

		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		String res = null;

		for (char c : set) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

			while (notSufficient(map)) {
				i++;
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
			}

			while (map.get(s.charAt(start)) + 1 <= 0) {
				map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
				start++;
			}

			if (i - start + 1 < min) {
				min = i - start + 1;
				res = s.substring(start, i + 1);
			}
		}

		return res;
	}

	private static boolean notSufficient(Map<Character, Integer> map) {
		for (int i : map.values()) {
			if (i > 0) {
				return true;
			}
		}

		return false;
	}
}