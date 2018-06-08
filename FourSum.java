import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = _fourSumSolution(new int[]{1, 0, -1, 0, -2, 2}, 0);
        
        System.out.println(Arrays.toString(list.toArray()));
    }
 
    private static List<List<Integer>> _fourSumSolution(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
        int high, low, sum;
        Arrays.sort(nums);

		for(int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				high = nums.length - 1;
				low = j + 1;

				while (high > low) {
					sum = nums[i] + nums[j] + nums[low] + nums[high];

					if (sum == target) {
						List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
						if (!res.contains(list)) {
							res.add(list);
						}
						
						low++;
						high--;
					} else if (sum > target) {
						high--;
					} else {
						low++;
					}
				}
			}
		}

        return res;
    }
}