import java.util.*;
import java.util.Map.Entry;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(_reorganizeString("aab"));
    }
 
    private static String _reorganizeString(String S) {
		if (S == null || S.length() == 0) {
			return "";
		}

		Map<Character, Integer> charCount = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for (char c : S.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(((a, b) -> (b.getValue() - a.getValue())));
		pq.addAll(charCount.entrySet());
		Map.Entry<Character, Integer> lastEntry = null;

		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			sb.append(entry.getKey());
			entry.setValue(entry.getValue() - 1);

			if (lastEntry != null && lastEntry.getValue() > 0) {
				pq.offer(lastEntry);
			}

			lastEntry = entry;
		}
		
		return sb.length() == S.length() ? sb.toString() : "";
    }
}