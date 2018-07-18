import java.util.*;

public class PalindromicSubstrings {
    public static void main(String[] args) {
		System.out.println(countSubstrings("aaa"));
    }
 
    private static int countSubstrings(String s) {
		int count = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1]);
				if (dp[i][j])	count++;
			}
		}

		return count;
	}
}