import java.util.*;

public class ShortestPhrase {
    public static void main(String[] args) {
		System.out.println(getLength(2, 7, new String[]{"i","love","lintcode","so","much"}));
	}

	private static int getLength(int k, int lim, String[] str) {
        if (str.length < k) {
            return -1;
        }
        
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = str[i].length();
		}
		
		System.out.println(Arrays.toString(nums));
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while (end < str.length) {
			sum += nums[end];

            while (end - start + 1 < k || sum < lim) {
                end++;
                sum += nums[end];
            }
            
            while (sum - nums[start] >= lim && end - start >= k) {
                sum -= nums[start];
                start++;
            }
			
            min = Math.min(min, sum);
			end++;
        }
        
        return min;
    }
}