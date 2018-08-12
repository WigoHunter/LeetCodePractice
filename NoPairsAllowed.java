import java.util.*;

public class NoPairsAllowed {
    public static void main(String[] args) {
		System.out.println(modify("ab"));
		System.out.println(modify("aab"));
		System.out.println(modify("abb"));
		System.out.println(modify("abab"));
		System.out.println(modify("abaaaba"));
    }

    private static int modify(String s) {
		int count = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				s = s.substring(0, i + 1) + '-' + s.substring(i + 2);
				count++;
			}
		}

		return count;
	}
}