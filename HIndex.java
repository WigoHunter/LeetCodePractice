import java.util.*;

public class HIndex {
   	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{0}));
    }
 
    private static int hIndex(int[] citations) {
		int[] counts = new int[citations.length + 1];
		int leng = citations.length;
		Arrays.fill(counts, 0);
        
        for (int i = 0; i < leng; i++) {
            if (citations[i] >= leng) {
				counts[leng]++;
			} else {
				counts[citations[i]]++;
			}
		}
		
		int count = 0;
		for (int i = leng; i >= 0; i--) {
			count += counts[i];

			if (count >= i) {
				return i;
			}
		}

		return 0;
    }
}