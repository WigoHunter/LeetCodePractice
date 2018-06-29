import java.util.*;

public class MountainSequence {
    public static void main(String[] args) {
		System.out.println(mountainSequence(new int[]{ 10, 9, 8, 7 }));
	}

	private static int mountainSequence(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;
			if (mid + 1 < nums.length && nums[mid] < nums[mid + 1])	low = mid;
			else if (mid >= 1 && nums[mid - 1] > nums[mid])	high = mid;
			else return nums[mid];
		}

		return nums[0];
	}
}