import java.util.*;

public class nQueens {
    public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		for (List<String> board : res) {
			for (String row : board) {
				System.out.println(row);
			}
			System.out.println("NEXT");
		}
	}

	private static List<List<String>> solveNQueens(int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		List<Integer> possibles = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			possibles.add(i);
		}

		helper(cols, possibles, res);
		return buildBoard(res, n);
	}

	private static void helper(List<Integer> cols, List<Integer> possibles, List<List<Integer>> res) {
		if (possibles.size() == 0) {
			res.add(new ArrayList<>(cols));
			return;
		}

		for (int i = 0; i < possibles.size(); i++) {
			if (!isValid(cols, possibles.get(i))) {
				continue;
			}

			int num = possibles.get(i);
			cols.add(num);
			possibles.remove(i);
			helper(cols, possibles, res);
			cols.remove(cols.size() - 1);
			possibles.add(i, num);
		}
	}

	private static boolean isValid(List<Integer> cols, int col) {
		int row = cols.size();

		for (int i = 0; i < cols.size(); i++) {
			if (i + cols.get(i) == row + col || i - cols.get(i) == row - col) {
				return false;
			}
		}

		return true;
	}

	private static List<List<String>> buildBoard(List<List<Integer>> res, int n) {
		List<List<String>> ans = new ArrayList<>();

		for (List<Integer> board : res) {
			List<String> temp = new ArrayList<>();

			for (int i : board) {
				StringBuilder sb = new StringBuilder("");
				for (int j = 0; j < n; j++) {
					if (j == i) {
						sb.append('Q');
					} else {
						sb.append('.');
					}
				}
				temp.add(sb.toString());
			}

			ans.add(temp);
		}

		return ans;
	}
}