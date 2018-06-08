import java.util.*;

public class moveZeroes {

    public static void main(String[] args) {
		_moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
 
    private static void _moveZeroes(int[] nums) {
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[cur++] = nums[i];
			}
		}

		for (int i = cur; i < nums.length; i++) {
			nums[i] = 0;
		}

		System.out.println(Arrays.toString(nums));
    }
}