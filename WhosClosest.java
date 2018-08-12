import java.util.*;

public class WhosClosest {
    public static void main(String[] args) {
		System.out.println(closest("hackerrank", 4));
		System.out.println(closest("hackerrank", 1));
		System.out.println(closest("hackerrank", 6));
		System.out.println(closest("hackerrank", 8));
    }

    private static int closest(String s, int index) {
		Map<Character, List<Integer>> mapCharToPos = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!mapCharToPos.containsKey(c)) {
				mapCharToPos.put(c, new ArrayList<>());
			}

			mapCharToPos.get(c).add(i);
		}

		List<Integer> pos = mapCharToPos.get(s.charAt(index));
		pos.remove((Integer) index);

		return pos.size() > 0 ? findClosest(pos, index) : -1;
	}

	private static int findClosest(List<Integer> list, int target) {
		int start = 0;
		int end = list.size() - 1;
		int mid = 0;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;

			if (list.get(mid) > target) {
				end = mid;
			} else if (list.get(mid) < target) {
				start = mid;
			} else {
				return list.get(mid);
			}
		}

		if (list.get(end) - target < target - list.get(start)) {
			return list.get(end);
		}

		return list.get(start);
	}
}