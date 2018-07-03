import java.util.*;

public class RemoveDuplication {
    public static void main(String[] args) {
		int[] nums = new int[]{1,3,1,4,4,2};
		System.out.println(deduplication(nums));

		System.out.println(Arrays.toString(nums));
    }

	private static int deduplication(int[] nums) {
		int left = 0, right = 0;
        List<Integer> list = new ArrayList<>();
        
        while (right < nums.length) {
            if (!list.contains(nums[right])) {
				list.add(nums[right]);
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
			}

            right++;
		}
		
		return left;
	}
}