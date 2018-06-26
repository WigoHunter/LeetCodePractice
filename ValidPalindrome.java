import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args) {
		System.out.println(isPalindrome(".,"));
	}
	
	private static boolean isPalindrome(String s) {
		if (s.isEmpty())	return true;
		int start = 0, end = s.length() - 1;

		while (start < end) {
			while (!Character.isLetterOrDigit(s.charAt(start)) && start < s.length() - 1) start++;
			while (!Character.isLetterOrDigit(s.charAt(end)) && end > 0) end--;

			if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end)) || start >= end) {
				start++;
				end--;
			} else {
				return false;
			}
		}

		return true;
	}

}