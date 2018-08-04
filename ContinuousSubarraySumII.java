import java.util.*;

public class ContinuousSubarraySumII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(continuousSubarraySum(new int[]{1,1,1,1,1,1,1,1,1,-19,1,1,1,1,1,1,1,-2,1,1,1,1,1,1,1,1,-2,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}).toArray()));
    }

    private static List<Integer> continuousSubarraySum(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}

		List<Integer> res = new ArrayList<>();
		int i = 0, j = 0;
		res.add(i);
		res.add(j);
		int min_preSum = 0;
		int sum = A[0];
		int max = A[0];
		
		for (int k = 1; k < A.length; k++) {
			if (sum < min_preSum) {
				min_preSum = sum;
				i = k;
			}

			sum += A[k];
			if (sum - min_preSum > max) {
				max = sum - min_preSum;
				j = k;
				res = new ArrayList<>();
				res.add(i);
				res.add(j);
			}
		}

		return res;
    }
}