import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[]{
			10,9,2,5,3,7,101,18
		}));
	}

	private static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)	return 0;
		int[][] res = new int[nums.length][2];
		res[0][0] = 0;
		res[0][1] = 1;

		for (int i = 1; i < nums.length; i++) {
            res[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i][1] = Math.max(res[i][1], res[j][1] + 1);
                }
            }
            res[i][0] = Math.max(res[i - 1][1], res[i - 1][0]);
		}

		return Math.max(res[nums.length - 1][0], res[nums.length - 1][1]);
	}
}