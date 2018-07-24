import java.util.*;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[]{1, 2, 3}));
    }
 
	private static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)	return false;
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;

		for (int num : nums) {
			if (num <= min) min = num;
			else if (num < secondMin)	secondMin = num;
			else if (num > secondMin) 	return true;
		}

		return false;
	}
}