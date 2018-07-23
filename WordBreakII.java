import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
		Set<String> set = new HashSet<>(Arrays.asList("de", "ding", "co", "code", "lint"));
		System.out.println(Arrays.toString(wordBreak("lintcode", set).toArray()));
	}

	private static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0)	return res;

		int leng = s.length();
		boolean[][] isWord = new boolean[leng][leng];
		for (int i = 0; i < leng; i++) {
			for (int j = i; j < leng; j++) {
				isWord[i][j] = wordDict.contains(s.substring(i, j + 1));
			}
		}

		boolean[] possible = new boolean[leng + 1];
		possible[leng] = true;
		for (int i = leng - 1; i >= 0; i--) {
			for (int j = i; j < leng; j++) {
				if (isWord[i][j] && possible[j + 1]) {
					possible[i] = true;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(possible));

		List<String> list = new ArrayList<>();
		dfs(s, 0, list, isWord, possible, res);
		return res;
	}

	private static void dfs(String s, int start, List<String> list, boolean[][] isWord, boolean[] possible, List<String> res) {
		if (!possible[start])	return;

		if (start == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				if (i != list.size() - 1)	sb.append(" ");
			}

			res.add(sb.toString());
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (!isWord[start][i])	continue;

			list.add(s.substring(start, i + 1));
			dfs(s, i + 1, list, isWord, possible, res);
			list.remove(list.size() - 1);
		}
	}
}