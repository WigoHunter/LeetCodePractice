import java.util.*;

public class BrickWall {
    public static void main(String[] args) {
		List<List<Integer>> wall = new ArrayList<>();
		wall.add(Arrays.asList(1));
		wall.add(Arrays.asList(1));
		wall.add(Arrays.asList(1));

		System.out.println(leastBricks(wall));
	}

	private static int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> mapColumnToLines = new HashMap<>();
		int max = 0;

		for (List<Integer> row : wall) {
			int cur = 0;

			for (int i = 0; i < row.size() - 1; i++) {
				cur += row.get(i);
				mapColumnToLines.put(cur, mapColumnToLines.getOrDefault(cur, 0) + 1);
			}
		}

		for (int v : mapColumnToLines.values()) {
			max = Math.max(max, v);
		}

		return wall.size() - max;
	}
}