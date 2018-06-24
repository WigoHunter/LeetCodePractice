import java.util.*;
import org.w3c.dom.css.Counter;

public class TotalHammingDistance {
    public static void main(String[] args) {
		System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
	}
    
    private static int totalHammingDistance(int[] nums) {
        int count = 0;
        int k;
        int one = 1;

        for (int i = 0; i < 32; i++) {
            k = 0;
            for (int num : nums) {
                if ((num & one) != 0) k++;
            }

            count += k * (nums.length - k);
            one <<= 1;
        }

        return count;
    }
}