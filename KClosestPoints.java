import java.util.*;

public class KClosestPoints {
	private static class Point {
		int x, y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	public static void main(String[] args) {
		Point[] res = kClosest(new Point[]{
			new Point(4, 6), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)
		}, new Point(0, 0), 3);

		for (Point p : res) {
			//System.out.println(p.x + ", " + p.y);
		}
	}

	private static Point[] kClosest(Point[] points, Point origin, int k) {
		Point[] res = new Point[k];
		if (points == null || points.length == 0)	return res;
		if (points.length <= k) {
			return points;
		}

		Queue<Point> pq = new PriorityQueue<Point>(((a, b) -> dist(a, b, origin)));

		for (Point p : points) {
			pq.offer(p);
		}

		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		
		return res;
	}

	private static int dist(Point a, Point b, Point origin) {
		double distA = Math.pow(origin.x - a.x, 2) + Math.pow(origin.y - a.y, 2);
		double distB = Math.pow(origin.x - b.x, 2) + Math.pow(origin.y - b.y, 2);

		if (distA == distB) {
			if (a.x == b.x) {
				return a.y - b.y;
			}

			return a.x - b.x;
		}

		return (int) (distA - distB);
	}
}