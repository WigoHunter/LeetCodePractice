import java.util.*;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{1, 2, 3}, 5));
    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)    return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (k != 0) count %= k;

            if (map.containsKey(count)) {
                if (i - map.get(count) > 1) return true;
            } else {
                map.put(count, i);
            }
        }

        return false;
    }
}