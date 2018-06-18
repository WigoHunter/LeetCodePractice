import java.util.*;

public class KthLargestElementInArray {
    public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
	}

	private static int findKthLargest(int[] nums, int k) {
		Queue<Integer> q = new PriorityQueue<>(((a, b) -> a - b));
		for (int i : nums) {
			q.offer(i);
			if (q.size() > k)
				q.poll();
		}

		return q.peek();
	}
}