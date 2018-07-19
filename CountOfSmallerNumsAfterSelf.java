import java.util.*;

public class CountOfSmallerNumsAfterSelf {
    public static void main(String[] args) {
		int[] nums = new int[]{5, 2, 6, 1};
		System.out.println(Arrays.toString(countSmaller(nums).toArray()));
	}
    
    private static List<Integer> countSmaller(int[] nums) {
		List<Integer> sortedNums = new ArrayList<>();
		List<Integer> res = new ArrayList<>();

		sortedNums.add(nums[nums.length - 1]);
		res.add(0);

		for (int i = nums.length - 2; i >= 0; i--) {
			int index = binarySerach(sortedNums, nums[i]);
			sortedNums.add(index, nums[i]);
			res.add(0, index);
		}

		return res;
	}

	private static int binarySerach(List<Integer> nums, int target) {
		int start = 0;
		int end = nums.size() - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums.get(mid) >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}