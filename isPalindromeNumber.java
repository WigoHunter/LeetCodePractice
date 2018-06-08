import java.util.Arrays;

public class isPalindromeNumber {

    public static void main(String[] args) {
        System.out.println(_isPalindromeNumber(1001));
    }
 
    
    private static boolean _isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        int i = x;
        int j = 0;

        while(i >= 10) {
            j = j * 10 + (i % 10);
            i = i / 10;
        }

        j = j * 10 + (i % 10);
        return x == j;
    }
}