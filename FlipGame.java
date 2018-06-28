import java.util.*;

public class FlipGame {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(gen("").toArray()));
	}

	private static List<String> gen(String s) {
		List<String> res = new ArrayList<>();

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.substring(i, i + 2).equals("++")) {
				res.add(s.substring(0, i) + "--" + s.substring(i + 2));
			}
		}

		return res;
	}
}