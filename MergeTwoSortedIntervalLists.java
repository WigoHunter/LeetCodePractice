import java.util.*;

public class MergeTwoSortedIntervalLists {
	public static class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

    public static void main(String[] args) {
		List<Interval> list1 = Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(4, 5));
		List<Interval> list2 = Arrays.asList(new Interval(0, 1), new Interval(2, 3), new Interval(5, 6));
		List<Interval> res = mergeTwoInterval(list1, list2);
		
		for (Interval i : res) {
			System.out.println("[" + i.start + ", " + i.end + "]");
		}
	}

	private static Interval merge(Interval cur, Interval interval, List<Interval> res) {
		int start = cur.start;
		int end = cur.end;

		if (start == -1 && end == -1){
			start = interval.start;
			end = interval.end;
		} else if (interval.start > end) {
			res.add(new Interval(start, end));
			start = interval.start;
			end = interval.end;
		} else {
			start = Math.min(start, interval.start);
			end = Math.max(end, interval.end);
		}

		return new Interval(start, end);
	}

	private static List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
		if (list1 == null)	return list2;
		if (list2 == null)	return list1;

		int i = 0, j = 0;
		Interval cur = new Interval(-1, -1);
		List<Interval> res = new ArrayList<>();

		while (i < list1.size() && j < list2.size()) {
			Interval interval = list1.get(i).start < list2.get(j).start ? list1.get(i++) : list2.get(j++);
			cur = merge(cur, interval, res);
		}

		while (i < list1.size()) {
			Interval interval = list1.get(i++);
			cur = merge(cur, interval, res);
		}

		while (j < list2.size()) {
			Interval interval = list2.get(j++);
			cur = merge(cur, interval, res);
		}

		res.add(cur);
		return res;
	}
}