import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class MergeIntervals {
	private static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

    public static void main(String[] args) {
		Interval i1 = new Interval(1, 1);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 18);

		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);

		list = merge(list);
		
		for (Interval interval : list) {
			printInterval(interval);
		}
	}
	
	private static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals.size() == 0)	return res;

		Queue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
		pq.addAll(intervals);

		Interval cur = pq.poll();
		int start = cur.start;
		int end = cur.end;

		while(!pq.isEmpty()) {
			cur = pq.poll();
			if (cur.start > end ) {
				res.add(new Interval(start, end));
				start = cur.start;
				end = cur.end;
			} else {
				start = Math.min(start, cur.start);
				end = Math.max(end, cur.end);
			}
		}

		res.add(new Interval(start, end));

		return res;
	}

	/*
	Initial Attempt
	
	private static List<Interval> merge(List<Interval> intervals) {
		Queue<Integer> pq = new PriorityQueue<>((a,b) ->  a - b);

		for (Interval interval : intervals) {
			for (int i = interval.start; i <= interval.end; i++) {
				if (!pq.contains(i))
					pq.offer(i);
			}
		}

		return buildIntervals(pq);
	}

	private static List<Interval> buildIntervals(Queue<Integer> queue) {
		List<Interval> res = new ArrayList<>();
		
		int start;
		int cur;

		while (!queue.isEmpty()) {
			start = queue.poll();
			cur = start + 1;

			while (queue.contains(cur)) {
				queue.poll();
				cur++;
			}

			Interval interval = new Interval(start, cur - 1);
			res.add(interval);
		}
		
		return res;
	}

	*/

	private static void printInterval(Interval interval) {
		System.out.println("[" + interval.start + "," + interval.end + "]");
	}
	
}