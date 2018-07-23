import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(letterCombinations("23").toArray()));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		Map<Character, List<Character>> map = buildMap();
		helper(digits, new StringBuilder(), map, res);

		return res;
	}

	private static void helper(String digits, StringBuilder sb, Map<Character, List<Character>> map, List<String> res) {
		if (digits.length() == 0) {
			res.add(sb.toString());
			return;
		}

		char digit = digits.charAt(0);
		if (!map.containsKey(digit)) {
			return;
		}

		for (char c : map.get(digit)) {
			sb.append(c);
			helper(digits.substring(1), sb, map, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static Map<Character, List<Character>> buildMap() {
		Map<Character, List<Character>> map = new HashMap<>();

		map.put('2', Arrays.asList('a', 'b', 'c'));
		map.put('3', Arrays.asList('d', 'e', 'f'));
		map.put('4', Arrays.asList('g', 'h', 'i'));
		map.put('5', Arrays.asList('j', 'k', 'l'));
		map.put('6', Arrays.asList('m', 'n', 'o'));
		map.put('7', Arrays.asList('p', 'q', 'r', 's'));
		map.put('8', Arrays.asList('t', 'u', 'v'));
		map.put('9', Arrays.asList('x', 'y', 'z'));

		return map;
	}
}