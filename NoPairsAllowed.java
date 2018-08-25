import java.util.*;

public class NoPairsAllowed {
    public static void main(String[] args) {
			System.out.println(modify("ab"));
			System.out.println(modify("aab"));
			System.out.println(modify("abb"));
			System.out.println(modify("abab"));
			System.out.println(modify("abaaaaaba"));
			System.out.println(modify("add"));
			System.out.println(modify("ooo"));
			System.out.println(modify("break"));
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