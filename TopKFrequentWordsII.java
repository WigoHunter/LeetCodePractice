import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {
	int size;
	Queue<String> pq;
	Map<String, Integer> map;

	public TopK(int k) {
		pq = new PriorityQueue<>(((a, b) -> compare(a, b)));
		map = new HashMap<>();
		size = k;
	}

	public void add(String word) {
		map.put(word, map.getOrDefault(word, 0) + 1);

		if (pq.contains(word)) {
			pq.remove(word);
		}

		pq.offer(word);
		if (pq.size() > k) {
			pq.poll();
		}
	}

	public List<String> topK() {
		List<String> res = new ArrayList<>();
		Iterator i = pq.iterator();
		while (i.hasNext()) {
			res.add(i.next());
		}
		return res;
	}

	private int compare(String a, String b) {
		if (a.equals(b)) {
			return 0;
		}

		int aCount = map.get(a);
		int bCount = map.get(b);

		if (aCount != bCount) {
			return aCount - bCount;
		}

		return b.compareTo(a);
	}
}