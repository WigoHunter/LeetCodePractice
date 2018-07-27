import java.util.*;

public class PrefixAndSuffixSearch {
	private static class TrieNode {
		Map<Character, TrieNode> map;
		Integer weight;
		TrieNode() {
			map = new HashMap<>();
		}
	}

	public static class WordFilter {
		private TrieNode root;

		public WordFilter(String[] words) {
			root = buildTrie(words);
		}

		public int f(String prefix, String suffix) {
			TrieNode cur = root;

			for (char c : prefix.toCharArray()) {
				if (!cur.map.containsKey(c)) {
					return -1;
				}

				cur = cur.map.get(c);
			}

			return dfs(cur, suffix, 0);
		}

		private int dfs(TrieNode cur, String suffix, int count) {
			if (cur.weight != null && count == suffix.length()) {
				System.out.println("lol: " + cur.weight);
				return cur.weight;
			}

			for (Map.Entry<Character, TrieNode> e : cur.map.entrySet()) {
				System.out.println("suffix: " + suffix);
				System.out.println("index: " + count);
				System.out.println("key: " + e.getKey());
				System.out.println();
				if (e.getKey() == suffix.charAt(count)) {
					return dfs(e.getValue(), suffix, count + 1);
				}

				return dfs(e.getValue(), suffix, count);
			}

			return -1;
		}

		private TrieNode buildTrie(String[] words) {
			TrieNode root = new TrieNode();
			TrieNode cur;

			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				cur = root;

				for (char c : word.toCharArray()) {
					if (!cur.map.containsKey(c)) {
						cur.map.put(c, new TrieNode());
					}

					cur = cur.map.get(c);
				}

				cur.weight = i;
			}

			return root;
		}
	}

	public static void main(String[] args) {
		WordFilter w = new WordFilter(new String[]{"apple"});
		System.out.println(w.f("a", "e"));
		System.out.println(w.f("b", ""));
	}
}