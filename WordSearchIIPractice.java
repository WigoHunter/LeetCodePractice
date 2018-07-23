import java.util.*;

public class WordSearchIIPractice {
	private static class TrieNode {
        Map<Character, TrieNode> next = new HashMap<>();
        String word;
	}
	
    public static void main(String[] args) {
		char[][] board = new char[][]{
			{'o', 'a', 'a', 'n'},
			{'e', 't', 'a', 'e'},
			{'i', 'h', 'k', 'r'},
			{'i', 'f', 'l', 'v'}
		};

		System.out.println(Arrays.toString(findWords(board, new String[]{"oath", "pea", "eat", "rain"}).toArray()));
	}

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				explore(board, i, j, root, res);
			}
		}

		return res;
	}

	private static void explore(char[][] board, int i, int j, TrieNode node, List<String> res) {
		char c = board[i][j];

		if (c == '-' || !node.next.containsKey(c))	return;
		node = node.next.get(c);

		if (node.word != null) {
			res.add(node.word);
			node.word = null;
		}

		board[i][j] = '-';
		if (i > 0)	explore(board, i - 1, j, node, res);
		if (j > 0)	explore(board, i, j - 1, node, res);
		if (i < board.length - 1)	explore(board, i + 1, j, node, res);
		if (j < board[0].length - 1)	explore(board, i, j + 1, node, res);
		board[i][j] = c;
	}

	private static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		TrieNode cur;
		
		for (String s : words) {
			cur = root;

			for (char c : s.toCharArray()) {
				if (!cur.next.containsKey(c)) {
					cur.next.put(c, new TrieNode());
				}

				cur = cur.next.get(c);
			}

			cur.word = s;
		}

		return root;
	}
}