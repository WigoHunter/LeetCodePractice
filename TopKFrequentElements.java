import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentElements {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(findKthLargest(new int[] {1, 1, 1, 2, 2, 3}, 2).toArray()));
	}

	private static List<Integer> findKthLargest(int[] nums, int k) {
		Map<Integer, Integer> mapElementToFreq = new HashMap<>();

		for (int i : nums) {
			mapElementToFreq.put(i, mapElementToFreq.getOrDefault(i, 0) + 1);
		}

		Queue<Entry<Integer, Integer>> q = new PriorityQueue<>(((a, b) -> b.getValue() - a.getValue()));
		q.addAll(mapElementToFreq.entrySet());

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(q.poll().getKey());
		}

		return res;
	}
}