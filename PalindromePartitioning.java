import java.util.*;

public class PalindromePartitioning {
	private static List<List<String>> res;
	private static boolean[][] isPalindrome;

    public static void main(String[] args) {
		System.out.println(Arrays.toString(partition("aab").toArray()));
	}

	private static List<List<String>> partition(String s) {
		res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}

		buildIsPalindrome(s);
		List<String> list = new ArrayList<>();
		helper(s, 0, list);
		return res;
	}

	private static void helper(String s, int start, List<String> list) {
		if (start == s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (!isPalindrome[start][i]) {
				continue;
			}

			list.add(s.substring(start, i + 1));
			helper(s, i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	private static void buildIsPalindrome(String s) {
		int leng = s.length();
		isPalindrome = new boolean[leng][leng];
		for (int i = 0; i < leng; i++) {
			isPalindrome[i][i] = true;
		}

		for (int i = 0; i < leng - 1; i++) {
			isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}

		for (int i = leng - 3; i >= 0; i--) {
			for (int j = i + 2; j < leng; j++) {
				isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
			}
		}
	}
}