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
			int count = 0;
			return search(word, root, count);
		}

		public boolean search(String word, TrieNode from, int count) {
			TrieNode cur = from;
			int i = 0;
			
			for (char c : word.toCharArray()) {
				if (c != '.') {
					if (cur.map.containsKey(c)) {
						cur = cur.map.get(c);
						count++;
					} else {
						return false;
					}
				} else {
					for (char temp : cur.map.keySet()) {
						if (search(word.substring(i + 1), cur.map.get(temp), 0)) {
							return true;
						}
					}
				}

				i++;
			}

			return count == word.length() && cur.end;
		}
	}

    public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("aa");
		System.out.println(obj.search("a."));
    }
}