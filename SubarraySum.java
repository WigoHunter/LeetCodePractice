import java.util.*;

public class SubarraySum {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(subarraySum(new int[]{-3, 1, 2, -3, 4}).toArray()));
	}

	private static List<Integer> subarraySum(int[] nums) {
		Map<Integer, Integer> preSum = new HashMap<>();
        List<Integer> res = new ArrayList<>();
		int sum = 0;
		preSum.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if (preSum.containsKey(sum)) {
				res.add(preSum.get(sum) + 1);
				res.add(i);
				return res;
			}

			preSum.put(sum, i);
        }
        
        return res;
	}
}