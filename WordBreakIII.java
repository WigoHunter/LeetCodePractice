import java.util.*;

public class WordBreakIII {
    public static void main(String[] args) {
		List<String> set = new ArrayList<>(Arrays.asList("de", "ding", "co", "code", "lint"));
		System.out.println(Arrays.toString(wordBreak("lintcode", set).toArray()));
	}

	private static List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> mem = new HashMap<>();
		return dfs(s, wordDict, mem);	
	}

	private static List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> mem) {
		if (mem.containsKey(s)) {
			return mem.get(s);
		}

		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}

		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> list = dfs(s.substring(word.length()), wordDict, mem);
				for (String str : list) {
					res.add(word + (str.isEmpty() ? "" : " ") + str);
				}
			}
		}

		mem.put(s, res);
		return res;
	}
}