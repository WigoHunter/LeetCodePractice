import java.util.*;

public class LongestContinuousIncreasingSubsequence {
	
    public static void main(String[] args) {
		System.out.println(longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 3, 1}));
	}
    
    private static int longestIncreasingContinuousSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		if (nums.length < 2) {
		    return 1;
		}

		int maxLeft = 0, maxRight = 1;
		int left = 0, right = 1;

		for (int i = 2; i < nums.length; i++) {
			if ((nums[i] - nums[i - 1]) * (nums[i - 1] - nums[i - 2]) > 0) {
				right++;
			} else {
				if (right - left > maxRight - maxLeft) {
					maxRight = right;
					maxLeft = left;
				}

				left = i;
				right = i + 1;
			}
		}

		return Math.max(maxRight - maxLeft, right - left) + 1;
    } 
}