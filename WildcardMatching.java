import java.util.*;

public class WildcardMatching {
	public static void main(String[] args) {
		System.out.println(solution("aa", "a*"));
	}
	
	private static boolean solution(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		boolean[][] memo = new boolean[s.length()][p.length()];
		boolean[][] visited = new boolean[s.length()][p.length()];
		return isMatch(s, 0, p, 0, memo, visited);
	}

	private static boolean isMatch(String s, int sIndex,
									String p, int pIndex,
									boolean[][] memo,
									boolean[][] visited) {
		if (pIndex == p.length()) {
			return sIndex == s.length();
		}

		if (sIndex == s.length()) {
			return emptyPattern(p, pIndex);
		}

		if (visited[sIndex][pIndex]) {
			return memo[sIndex][pIndex];
		}

		char sChar = s.charAt(sIndex);
		char pChar = p.charAt(pIndex);
		boolean match;

		if (pChar == '*') {
			match = isMatch(s, sIndex + 1, p, pIndex, memo, visited) ||
				isMatch(s, sIndex, p, pIndex + 1, memo, visited);
		} else {
			match = (sChar == pChar || pChar == '?') && isMatch(s, sIndex + 1, p, pIndex + 1, memo, visited);
		}

		visited[sIndex][pIndex] = true;
		memo[sIndex][pIndex] = match;
		return match;
	}
 
    private static boolean isMatch(String s, String p) {
		System.out.println(s + " - " + p);
		if (s.length() == 0) {
			if (emptyPattern(p)) {
				return true;
			}

			return false;
		} else if (p.length() == 0) {
			return false;
		}

		if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
			return isMatch(s.substring(1), p.substring(1));
		}

		if (p.charAt(0) == '*') {
			int leng = count(p);
			for (int i = 0; i <= (s.length() - leng + 1); i++) {
				if (isMatch(s.substring(i), p.substring(1))) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean emptyPattern(String p, int index) {
		for (int i = index; i < p.length(); i++) {
			if (p.charAt(i) != '*') {
				return false;
			}
		}

		return true;
	}

	private static boolean emptyPattern(String p) {
		if (p.length() == 0)	return true;

		for (char c : p.toCharArray()) {
			if (c != '*') {
				return false;
			}
		}

		return true;
	}

	private static int count(String p) {
		int sum = 0;
		for (char c : p.toCharArray()) {
			if (c != '*') {
				sum++;
			}
		}

		return sum;
	}
}