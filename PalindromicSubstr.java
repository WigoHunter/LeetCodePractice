public class Solution {
    /**
     * @param str: s string
     * @return: return an integer, denote the number of the palindromic substrings
     */
    public int countPalindromicSubstrings(String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            count += search(str, i, i) + search(str, i, i + 1);
        }
        
        return count;
    }
    
    private int search(String s, int i, int j) {
        int count = 0;
        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        
        return count;
    }
}