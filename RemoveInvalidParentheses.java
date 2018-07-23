import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(removeInvalidParentheses("()())()").toArray()));
	}

	private static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;

		int l = 0, r = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				l++;
			} else if (s.charAt(i) == ')') {
				if (l > 0) {
					l--;
				} else {
					r++;
				}
			}
		}

		dfs(new StringBuilder(s), 0, l, r, res);
		return res;
	}

	private static void dfs (StringBuilder sb, int start, int l, int r, List<String> res) {
		if (l == 0 && r == 0 && isValid(sb)) {
			res.add(sb.toString());
			return;
		}

		for (int i = start; i < sb.length(); i++) {
			if (i > start && sb.charAt(i) == sb.charAt(i - 1))	continue;

			if (sb.charAt(i) == '(' && l > 0) {
				sb.deleteCharAt(i);
				dfs(sb, i, l - 1, r, res);
				sb.insert(i, '(');
			} else if (sb.charAt(i) == ')' && r > 0) {
				sb.deleteCharAt(i);
				dfs(sb, i, l, r - 1, res);
				sb.insert(i, ')');
			}
		}
	}

	private static boolean isValid(StringBuilder sb) {
		int count = 0;

		for (char c : sb.toString().toCharArray()) {
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}

			if (count < 0)	return false;
		}

		return true;
	}
}