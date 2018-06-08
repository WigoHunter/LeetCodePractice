import java.util.Arrays;

public class isPermutationOfPalindrome {

    public static void main(String[] args) {
        System.out.println(Boolean.toString(_isPermutationOfPalindrome("Tacta")));
    }
 
    
    private static boolean _isPermutationOfPalindrome(String s) {
        int countOdd = 0;
        int numOfChars = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
        int[] table = new int[numOfChars];

        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
            }
        }

        for (int i = 0; i < numOfChars; i++) {
            if(table[i] % 2 == 1)
                countOdd++;
        }

        return countOdd <= 1;
    } 

    private static int getCharNumber(Character ch) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int c = Character.getNumericValue(ch);
		if (c >= a && c <= z) return c - a;
		return -1;
	}
}