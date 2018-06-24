import java.util.*;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingWeight(17));
	}
    
    private static int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += xor % 2;
            xor >>= 1;
        }

        return count;
    }

    private static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> 1 << 1) ^ n;
            n >>= 1;
        }
        
        return count;
    }
}