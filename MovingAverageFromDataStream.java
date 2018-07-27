import java.util.*;

public class MovingAverageFromDataStream {
	public static class MovingAverage {
		Queue<Integer> q;
		int size;
		double sum;

		public MovingAverage(int size) {
			this.size = size;
			this.q = new LinkedList<>();
			this.sum = 0.0;
		}

		public double next(int val) {
			if (q.size() >= size) {
				sum -= q.poll();
			}

			q.offer(val);
			sum += val;

			return sum / q.size();
		}
	}

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
	}
}