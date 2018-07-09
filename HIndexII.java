import java.util.*;

public class HIndexII {
   	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
    }
 
    private static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
            return 0;
		}
		
		int start = 0, end = citations.length - 1, mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;

			if (citations[mid] > citations.length - mid) {
				if (mid > 0 && citations[mid - 1] >= citations.length - mid) {
					end = mid;
				} else {
					return citations.length - mid;
				}
			} else {
				start = mid;
			}
		}

		if (citations[start] >= citations.length - start && (start == 0 || citations[start - 1] <= citations.length - start)) {
			return citations.length - start;
		}

		if (citations[end] >= citations.length - end && (end == 0 || citations[end - 1] <= citations.length - end)) {
			return citations.length - end;
		}

		return 0;
    }
}