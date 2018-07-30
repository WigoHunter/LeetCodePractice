import java.util.*;

public class RegexMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("ab", ".*"));
	}
	
	private static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		boolean[][] visited = new boolean[s.length()][p.length()];
		boolean[][] memo = new boolean[s.length()][p.length()];
		return isMatch(s, 0, p, 0, visited, memo);
	}

	private static boolean isMatch(String s, int sIndex, String p, int pIndex, boolean[][] visited, boolean[][] memo) {
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

		if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
			match = isMatch(s, sIndex, p, pIndex + 2, visited, memo) ||
				((sChar == pChar || pChar == '.') && isMatch(s, sIndex + 1, p, pIndex, visited, memo));
		} else {
			match = (sChar == pChar || pChar == '.') &&
				isMatch(s, sIndex + 1, p, pIndex + 1, visited, memo);
		}

		visited[sIndex][pIndex] = true;
		memo[sIndex][pIndex] = match;
		return match;
	}

	private static boolean emptyPattern(String p, int index) {
		for (int i = index; i < p.length(); i += 2) {
			if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
				return false;
			}
		}

		return true;
	}
}