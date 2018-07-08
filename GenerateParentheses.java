import java.util.*;

public class GenerateParentheses {
	public static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		System.out.println(Arrays.toString(res.toArray()));
	}
	
	private static List<String> generateParenthesis(int n) {
		buildParentheses("", n, n, n);
		return res;
	}

	private static void buildParentheses(String s, int start, int close, int n) {
		if (s.length() == 2 * n) {
			int startingCount = 0;

			for (char c : s.toCharArray()) {
				if (c == '(') {
					startingCount++;
				} else {
					if (startingCount <= 0) {
						return;
					} else {
						startingCount--;
					}
				}
			}

			res.add(s);
		} else {
			if (start > 0) {
				buildParentheses(s + '(', start - 1, close, n);
			}

			if (close > 0) {
				buildParentheses(s + ')', start, close - 1, n);
			}
		}
	}
}