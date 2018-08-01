import java.util.*;

public class MergeIntervalsII {
	private static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

    public static void main(String[] args) {
		List<Interval> list = Arrays.asList(new Interval(1, 3), new Interval(2, 6),
			new Interval(8, 10), new Interval(15, 18));
		
		list = merge(list);
		
		for (Interval interval : list) {
			printInterval(interval);
		}
	}
	
	private static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		Collections.sort(intervals, (((a, b) -> a.start - b.start)));
		Interval cur = intervals.get(0);
		int start = cur.start;
		int end = cur.end;

		for (int i = 1; i < intervals.size(); i++) {
			cur = intervals.get(i);
			if (cur.start > end) {
				res.add(new Interval(start, end));
				start = cur.start;
				end = cur.end;
			} else {
				end = Math.max(end, cur.end);
			}
		}

		res.add(new Interval(start, end));
		return res;
	}

	private static void printInterval(Interval interval) {
		System.out.println("[" + interval.start + "," + interval.end + "]");
	}
	
}