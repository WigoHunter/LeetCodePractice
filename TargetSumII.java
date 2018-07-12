import java.util.*;

public class TargetSumII {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int findTargetSumWays(int[] nums, int S) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int num : nums) {
			Map<Integer, Integer> next = new HashMap<>();

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int add = entry.getKey() + num;
				int minus = entry.getKey() - num;
				next.put(add, next.getOrDefault(add, 0) + entry.getValue());
				next.put(minus, next.getOrDefault(minus, 0) + entry.getValue());
			}

			map = next;
		}

		return map.getOrDefault(S, 0);
    }
}