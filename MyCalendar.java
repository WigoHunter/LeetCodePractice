import java.util.*;

public class MyCalendar {
	public static class Calendar {
		List<Integer> timeline;
		
		public Calendar() {
			timeline = new ArrayList<>();
		}

		public boolean book(int start, int end) {
			if (timeline.isEmpty()) {
				timeline.add(start);
				timeline.add(end);
				return true;
			}

			int curStart = timeline.get(0);
			int curEnd = timeline.get(timeline.size() - 1);
			
			if (end <= curStart) {
				timeline.add(0, end);
				timeline.add(0, start);
				return true;
			} else if (start >= curEnd) {
				timeline.add(start);
				timeline.add(end);
				return true;
			}

			for (int i = 1; i < timeline.size() - 1; i += 2) {
				if (start >= timeline.get(i) && end <= timeline.get(i + 1)) {
					timeline.add(i + 1, end);
					timeline.add(i + 1, start);
					return true;
				} else if (timeline.get(i) > end) {
					return false;
				}
			}

			return false;
		}
	}

    public static void main(String[] args) {
		Calendar c = new Calendar();
		System.out.println(c.book(10, 20));
		System.out.println(c.book(15, 25));
		System.out.println(c.book(20, 30));
	}
}