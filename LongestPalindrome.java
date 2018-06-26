import java.util.*;

public class LongestPalindrome {
    public static void main(String[] args) {
		System.out.println(longestPalindrome("ccc"));
	}

	private static int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				count += entry.getValue();
			} else {
				count += count % 2 == 0 ? entry.getValue() : entry.getValue() - 1;
			}
		}

		return count;
	}
}