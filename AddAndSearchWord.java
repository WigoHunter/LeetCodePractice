import java.util.*;

public class AddAndSearchWord {
	private static class TrieNode {
		public Map<Character, TrieNode> map;
		public boolean end;
		public TrieNode() {
			map = new HashMap<>();
		}
	}

	private static class WordDictionary {
		TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		public void addWord(String word) {
			TrieNode cur = root;

			for (char c : word.toCharArray()) {
				TrieNode node;
				
				if (cur.map.containsKey(c)) {
					node = cur.map.get(c);
				} else {
					node = new TrieNode();
					cur.map.put(c, node);
				}

				cur = node;
			}

			cur.end = true;
		}

		public boolean search(String word) {
			return search(word, root);
		}

		public boolean search(String word, TrieNode root) {
			if (word.length() == 0)	return root.end;
			if (root.map.isEmpty()) return false;

			char c = word.charAt(0);

			if (c == '.') {
				boolean found = false;
				
				for (TrieNode node : root.map.values()) {
					if(search(word.substring(1), node)) {
						found = true;
					}
				}

				return found;
			} else if (root.map.containsKey(c)) {
				return search(word.substring(1), root.map.get(c));
			}

			return false;
		}
	}

    public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("aa");
		System.out.println(obj.search("a."));
    }
}