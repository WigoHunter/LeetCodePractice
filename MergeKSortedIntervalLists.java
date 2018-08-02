import java.util.*;

public class MergeKSortedIntervalLists {
	public static class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class IntervalWrap {
		int row;
		int col;

		IntervalWrap(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

    public static void main(String[] args) {
		List<Interval> list1 = Arrays.asList(new Interval(1, 2), new Interval(3, 4));
		List<Interval> list2 = Arrays.asList(new Interval(2, 3), new Interval(5, 6));
		List<List<Interval>> list = Arrays.asList(list1, list2);
		List<Interval> res = mergeKSortedIntervalLists(list);
		
		for (Interval i : res) {
			System.out.println("[" + i.start + ", " + i.end + "]");
		}
	}

	private static List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
		List<Interval> res = new ArrayList<>();

		if (intervals == null || intervals.size() == 0) return res;

		Queue<IntervalWrap> pq = new PriorityQueue<>(((a, b) -> intervals.get(a.row).get(a.col).start - intervals.get(b.row).get(b.col).start));

		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).size() > 0) {
				pq.offer(new IntervalWrap(i, 0));
			}
		}

		while (!pq.isEmpty()) {
			IntervalWrap iw = pq.poll();
			res.add(intervals.get(iw.row).get(iw.col));
			iw.col++;

			if (iw.col < intervals.get(iw.row).size()) {
				pq.offer(iw);
			}
		}

		return merge(res);
	}

	private static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}

		List<Interval> res = new ArrayList<>();

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval i : intervals) {
			if (i.start > end) {
				res.add(new Interval(start, end));
				start = i.start;
				end = i.end;
			} else {
				end = Math.max(end, i.end);
			}
		}

		res.add(new Interval(start, end));
		return res;
	}

}