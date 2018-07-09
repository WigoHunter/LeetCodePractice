import java.util.*;

public class MyCalendarII {
	public static class Calendar {
		TreeMap<Integer, Integer> timeline;
		
		public Calendar() {
			timeline = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			timeline.put(start, timeline.getOrDefault(start, 0) + 1);
			timeline.put(end, timeline.getOrDefault(end, 0) - 1);
			int count = 0;

			for (int i : timeline.values()) {
				count += i;

				if (count >= 3) {
					timeline.put(start, timeline.get(start) - 1);
					timeline.put(end, timeline.get(end) + 1);
					return false;
				}
			}

			return true;
		}
	}

    public static void main(String[] args) {
		Calendar c = new Calendar();
		System.out.println(c.book(10, 20));
		System.out.println(c.book(50, 60));
		System.out.println(c.book(10, 40));
		System.out.println(c.book(5, 15));
		System.out.println(c.book(5, 10));
		System.out.println(c.book(25, 55));
	}
}