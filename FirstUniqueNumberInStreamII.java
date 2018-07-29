import java.util.*;

public class FirstUniqueNumberInStreamII {
	private static class DataStream {
		Map<Integer, Integer> mapIntToCount;
		LinkedList<Integer> list;

		public DataStream() {
			mapIntToCount = new HashMap<>();
			list = new LinkedList<>();
		}

		public void add(int num) {
			mapIntToCount.put(num, mapIntToCount.getOrDefault(num, 0) + 1);

			if (!list.contains(num))
				list.offer(num);
		}

		public int firstUnique() {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				int num = (int) it.next();
				int count = mapIntToCount.get(num);

				if (count == 1) {
					return num;
				} else if (count > 1) {
					it.remove();
				}
			}

			return -1;
		}
	}
	
    public static void main(String[] args) {
		DataStream d = new DataStream();
		d.add(1);
		d.add(2);
		System.out.println(d.firstUnique());
		d.add(1);
		System.out.println(d.firstUnique());
	}
}