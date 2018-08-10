import java.util.*;

public class SumOfKFirstPalindromeNumbers {
    public static void main(String[] args) {
		System.out.println(getPalindromeNumber(8));
	}

    private static int sumKEven(int k) {
        int sum = 0;
        
        for (int i = 1; i <= k; i++) {
            sum += getPalindromeNumber(i);
        }
        
        return sum;
    }
    
    private static int getPalindromeNumber(int i) {
        int cur = i;
        int multiplier = 1;
        int tail = 0;
        
        while (cur > 0) {
            tail = tail * 10 + cur % 10;
            cur /= 10;
            multiplier *= 10;
        }
        
        return tail + i * multiplier;
    }
}