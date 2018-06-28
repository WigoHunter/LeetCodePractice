import java.util.*;

public class RangeSumQuery {
	private static class NumArray {
		List<Integer> sums;

		NumArray(int[] nums) {
			sums = new ArrayList<>();
			sums.add(0);

			for (int i = 0; i < nums.length; i++) {
				sums.add(sums.get(i) + nums[i]);
			}
		}

		int sumRange(int i, int j) {
			return sums.get(j + 1) - sums.get(i);
		}
	}

    public static void main(String[] args) {
		NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
	}
}