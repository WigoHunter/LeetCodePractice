import java.util.*;

public class LCIS {
   	public static void main(String[] args) {
		System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
	}
	
	private static int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0)   return 0;
        int max = 1;
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				count++;
			} else {
				count = 1;
			}

			max = Math.max(max, count);
		}

		return max;
	}
}