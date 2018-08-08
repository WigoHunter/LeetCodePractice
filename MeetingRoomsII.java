import java.util.*;

public class MeetingRoomsII {
	private static class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

    public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.addAll(Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20), new Interval(19, 25)));
		System.out.println(minMeetingRooms(intervals));
	}
    
    private static int minMeetingRooms(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return 0;
		}

		Collections.sort(intervals, (((a, b) -> a.start - b.start)));
		Queue<Integer> pq = new PriorityQueue<>(((a, b) -> a - b));
		int max = 0;

		for (Interval interval : intervals) {
			popAllByTime(pq, interval.start);
			pq.offer(interval.end);
			max = Math.max(max, pq.size());
		}

		return max;
	}

	private static void popAllByTime(Queue<Integer> pq, int start) {
		while (!pq.isEmpty() && pq.peek() <= start) {
			pq.poll();
		}

		return;
	}
}