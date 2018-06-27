import java.util.*;

public class Triangle {
    public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		System.out.println(minimumTotal(triangle));
	}

	private static int minimumTotal(List<List<Integer>> triangle) {
		int temp;
		int min = Integer.MAX_VALUE;
		List<Integer> row, prevRow;

		for (int i = 1; i < triangle.size(); i++) {
			triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
			triangle.get(i).set(triangle.get(i).size() - 1, triangle.get(i).get(triangle.get(i).size() - 1) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1));
		}

		for (int i = 2; i < triangle.size(); i++) {
			row = triangle.get(i);
			prevRow = triangle.get(i - 1);

			for (int j = 1; j < row.size() - 1; j++) {
				temp = row.get(j) + Math.min(prevRow.get(j), prevRow.get(j - 1));
				row.set(j, temp);
			}
		}

		row = triangle.get(triangle.size() - 1);
		for (int i = 0; i < row.size(); i++) {
			min = Math.min(row.get(i), min);
		}

		return min;
	}	
}