import java.util.*;

public class WordSearch {
    public static void main(String[] args) {
		char[][] board = new char[][]{
			{'C', 'A', 'A'},
			{'A', 'A', 'A'},
			{'B', 'C', 'D'}
		};

		System.out.println(exist(board, "AAB"));
	}
	
	private static boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (explore(board, word, i, j, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean explore(char[][] board, String word, int i, int j, boolean[][] visited) {
		if (board == null || word == null)	return false;
		if (word.length() == 0)	return true;

		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || visited[i][j]) {
			return false;
		}

		if (board[i][j] == word.toCharArray()[0]) {
			visited[i][j] = true;

			boolean ans = explore(board, word.substring(1), i + 1, j, visited)
			|| explore(board, word.substring(1), i - 1, j, visited)
			|| explore(board, word.substring(1), i, j + 1, visited)
			|| explore(board, word.substring(1), i, j - 1, visited);

			if (ans) {
				return true;
			} else {
				visited[i][j] = false;
			}
		}

		return false;
	}
}