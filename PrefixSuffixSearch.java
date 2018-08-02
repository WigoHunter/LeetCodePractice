import java.util.*;

public class PrefixSuffixSearch {

	public static class WordFilter {
		private static class TrieNode {
			Map<Character, TrieNode> map;
			int weight;
			TrieNode() {
				map = new HashMap<>();
				weight = -1;
			}
		}

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

			StringBuilder branch = new StringBuilder(prefix);

			return dfs(cur, suffix, branch);
		}

		private static int dfs(TrieNode root, String suffix, StringBuilder branch) {
			if (root == null) {
				return -1;
			}

			if (root.weight >= 0 && branch.toString().endsWith(suffix)) {
				return root.weight;
			}

			int max = -1;

			for (Map.Entry<Character, TrieNode> e : root.map.entrySet()) {
				char c = e.getKey();
				branch.append(c);
				int l = branch.length();
				max = Math.max(max, dfs(e.getValue(), suffix, branch));
				branch.setLength(l - 1);
			}

			return max;
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
	}
}