import java.util.*;

public class LongestWordThroughDelete {
	public static void main(String[] args) {
		System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
	}

	private static String findLongestWord(String s, List<String> d) {
		Collections.sort(d, ((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()));
		
		char[] ss = s.toCharArray();
		for (String str : d) {
			if (valid(ss, str.toCharArray())) {
				return str;
			}
		}

		return "";
	}

	private static boolean valid(char[] s, char[] str) {
		int i = 0;
		int j = 0;

		while (i < s.length && j < str.length) {
			if (s[i] == str[j]) {
				i++;
				j++;
			} else {
				i++;
			}
		}

		return j == str.length;
	}
}