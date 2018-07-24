import java.util.*;

public class StringPermutationII {
   	public static void main(String[] args) {
		System.out.println(Arrays.toString(stringPermutation2("aabb").toArray()));
	}
	
	private static List<String> stringPermutation2(String str) {
		List<String> res = new ArrayList<>();

		List<Character> possibles = new ArrayList<>();
		for (char c : str.toCharArray()) {
			possibles.add(c);
		}
		Collections.sort(possibles);
		helper(possibles, new StringBuilder(), res);
		return res;
	}

	private static void helper(List<Character> chars, StringBuilder sb, List<String> res) {
		if (chars.size() == 0) {
			res.add(sb.toString());
			return;
		}

		for (int i = 0; i < chars.size(); i++) {
			if (i > 0 && chars.get(i) == chars.get(i - 1))	continue;

			char c = chars.get(i);
			sb.append(c);
			chars.remove(i);
			helper(chars, sb, res);
			sb.deleteCharAt(sb.length() - 1);
			chars.add(i, c);
		}
	}
}