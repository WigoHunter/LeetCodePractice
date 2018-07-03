import java.util.*;

public class TwoSumIII {
	private static class TwoSum {
		Queue<Integer> pq = new PriorityQueue<>(((a, b) -> a - b));

		TwoSum() {
			pq = new PriorityQueue<>(((a, b) -> a - b));
		}

		void add (int number) {
			pq.offer(number);
		}

		boolean find(int value) {
			List<Integer> list = new ArrayList<>();
			list.addAll(pq);
			int low = 0;
			int high = list.size() - 1;
			int temp;

			while (low < high) {
				temp = list.get(low) + list.get(high);
				if (temp > value) {
					high--;
				} else if (temp < value) {
					low++;
				} else {
					return true;
				}
			}

			return false;
		}
	}
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		ts.add(2);
		ts.add(-10);
		ts.add(3);
		System.out.println(ts.find(-8));
		System.out.println(ts.find(-7));
		System.out.println(ts.find(-10));
		System.out.println(ts.find(5));
		System.out.println(ts.find(-5));
		System.out.println(ts.find(-8));
	}
}
