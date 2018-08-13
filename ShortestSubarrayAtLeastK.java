import java.util.*;

public class ShortestSubarrayAtLeastK {
    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }

    private static int shortestSubarray(int[] A, int K) {
		int leng = A.length;
		int min = Integer.MAX_VALUE;
		int[] sum = new int[leng + 1];

		for (int i = 0; i < leng; i++) {
			sum[i + 1] = sum[i] + A[i];
		}

		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i <= leng; i++) {
			while (!dq.isEmpty() && sum[i] - sum[dq.getFirst()] >= K) {
				min = Math.min(min, i - dq.pollFirst());
			}

			while (!dq.isEmpty() && sum[i] <= sum[dq.getLast()]) {
				dq.pollLast();
			}

			dq.offerLast(i);
		}

		return min == Integer.MAX_VALUE ? -1 : min;
    }
}