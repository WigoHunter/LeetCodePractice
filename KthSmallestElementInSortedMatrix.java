import java.util.*;

public class KthSmallestElementInSortedMatrix {
	private static class Node {
		int x, y, val;
		Node (int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int res = kthSmallest(new int[][] {
			{1, 5, 9},
			{10, 11, 13},
			{12, 13, 15}
		}, 8);

		System.out.println(res);
    }
 
    private static int kthSmallest(int[][] matrix, int k) {
		Queue<Node> pq = new PriorityQueue<>(((a, b) -> a.val - b.val));
		
		for (int i = 0; i < matrix[0].length; i++) {
			pq.offer(new Node(0, i, matrix[0][i]));
		}

		Node cur = pq.poll();
		pq.offer(new Node(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));

		for (int i = 1; i < k; i++) {
			cur = pq.poll();

			if (cur.x < matrix.length - 1) {
				pq.offer(new Node(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
			}
		}

		return cur.val;
	}
}