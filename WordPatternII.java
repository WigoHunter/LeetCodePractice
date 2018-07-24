import java.util.*;

public class WordPatternII {
    public static void main(String[] args) {
		System.out.println(wordPatternMatch("bkmmofpuxj", "redblueredblue"));
	}

	private static boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> mapCharToPattern = new HashMap<>();
		Set<String> set = new HashSet<>();

		return helper(pattern, str, mapCharToPattern, set);
	}

	private static boolean helper(String pattern, String s, Map<Character, String> map, Set<String> set) {
		if (pattern.length() == 0) {
			return s.length() == 0;
		}

		Character c = pattern.charAt(0);
		if (map.containsKey(c)) {
			if (!s.startsWith(map.get(c))) {
				return false;
			}

			return helper(pattern.substring(1), s.substring(map.get(c).length()), map, set);
		}

		for (int i = 0; i < s.length(); i++) {
			String word = s.substring(0, i + 1);
			if (set.contains(word)) {
				continue;
			}
			map.put(c, word);
			set.add(word);
			if (helper(pattern.substring(1), s.substring(i + 1), map, set)) {
				return true;
			}
			set.remove(word);
			map.remove(c);
		}
		
		return false;
	}
}