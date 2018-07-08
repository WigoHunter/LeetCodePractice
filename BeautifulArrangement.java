import java.util.*;

public class BeautifulArrangement {
	private static int count = 0;

    public static void main(String[] args) {
		System.out.println(countArrangement(3));
	}
	
	private static int countArrangement(int N) {
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		buildArrangement(list, 1, N);
		return count;
	}

	private static void buildArrangement(List<Integer> list, int pos, int end) {
		if (pos == end && (list.get(0) % pos == 0 || pos % list.get(0) % pos == 0)) {
			count++;
		} else if (pos < end && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				System.out.println("compare: " + pos + " " + num);
				if (num % pos == 0 || pos % num == 0) {
					System.out.println("" + pos + " " + num);
					list.remove(i);
					List<Integer> newList = new ArrayList<>();
					newList.addAll(list);
					list.add(i, num);
					buildArrangement(newList, pos + 1, end);
				}
			}
		}
	}
}