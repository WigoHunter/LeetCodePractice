import java.util.*;

public class FirstUniqueNumber {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("abaccdeff"));
	}

	private static char firstUniqChar(String str) {
		List<Character> list = new ArrayList<>();
		boolean[] visited = new boolean[256];

		for (char c : str.toCharArray()) {
			if (!visited[c]) {
				if (list.contains(c)) {
					list.remove((Character) c);
					visited[c] = true;
				} else {
					list.add(c);
				}
			}
		}

		return list.get(0);
	}
}
