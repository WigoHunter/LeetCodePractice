import java.util.*;

public class MinSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    private static int minSubArrayLen(int s, int[] nums) {
        int cur = 0;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        boolean found = false;

        while (nums.length > cur) {
            sum += nums[cur];
            cur++;

            while (sum >= s) {
                found = true;
                minLen = Math.min(minLen, cur - left);
                sum -= nums[left];
                left++;
            }
        }

        return found ? minLen : 0;
    }
}