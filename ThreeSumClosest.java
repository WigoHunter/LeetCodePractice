import java.util.Arrays;
import java.util.List;
import java.util.*;

public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(_threeSumClosestSolution(new int[]{-1, 2, 1, 1}, 1));
    }
 
    private static int _threeSumClosestSolution(int[] nums, int target) {
		int high, low, cur;
		int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
			low = i + 1;
			high = nums.length - 1;

			while(high > low) {
				cur = nums[i] + nums[low] + nums[high];
				if (cur == target)
					return cur;
				else {
					if (Math.abs(closest - target) > Math.abs(cur - target)) {
						closest = cur;
					}
	
					if (cur > target) {
						high--;
					} else {
						low++;
					}
				}
			}
        }

        return closest;
    }
}