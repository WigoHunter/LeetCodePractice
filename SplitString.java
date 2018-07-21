import java.util.*;

public class SplitString {
    public static void main(String[] args) {
		System.out.println(splitString("123"));
	}
	
	private static List<List<String>> splitString(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0)	return res;

		helper(s, new ArrayList<>(), res);
		return res;
	}

	private static void helper(String s, List<String> list, List<List<String>> res) {
		if (s.length() == 0) {
			if (list.size() > 1) {
				res.add(new ArrayList<>(list));
			}
			
			return;
		}

		for (int i = 1; i <= 2 && i <= s.length(); i++) {
			String sub = s.substring(0, i);

			list.add(sub);
			helper(s.substring(i), list, res);
			list.remove(list.size() - 1);
		}
	}
}