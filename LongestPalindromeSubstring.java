import java.util.Arrays;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abcdzdcab"));
    }
 
    private static String longestPalindrome(String s) {
        int leng = 0, left, right;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left > leng) {
                    leng = right - left;
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left > leng) {
                    leng = right - left;
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return ans;
    }
}