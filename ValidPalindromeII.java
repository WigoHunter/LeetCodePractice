import java.util.*;

public class ValidPalindromeII {
    public static void main(String[] args) {
		System.out.println(valid("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
	}
	
	private static boolean valid(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return validate(s, start + 1, end) || validate(s, start, end - 1);
			}
		}

		return true;
	}

	private static boolean validate(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}

		return true;
	}
}