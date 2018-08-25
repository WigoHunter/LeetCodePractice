import java.util.*;

public class SalesForceOA {

    public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 3, 3, 3, 3};
        System.out.println(Arrays.toString(jobOffers(nums, new int[]{1, 1}, new int[]{5, 9})));
	}
	
	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int[] res = new int[lowerLimits.length];
        Arrays.sort(scores);
        
        for (int i = 0; i < lowerLimits.length; i++) {
            int start = indexOfFirst(scores, lowerLimits[i]);
			int end = indexOfLast(scores, upperLimits[i]);
			
            if (start == -1 || end == -1 || end < start) {
                res[i] = 0;
            } else {
                res[i] = end - start + 1;
            }
        }
        
        return res;
    }

    static int indexOfFirst(int[] scores, int min) {
        int start = 0;
        int end = scores.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (scores[mid] < min) {
                 start = mid;
            } else {
                end = mid;
            }
        }
        
        if (scores[start] >= min) {
            return start;
        } else if (scores[end] >= min) {
            return end;
        }
        
        return -1;
    }

    static int indexOfLast(int[] scores, int max) {
        int start = 0;
        int end = scores.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (scores[mid] > max) {
                 end = mid;
            } else {
                start = mid;
            }
        }
        
        if (scores[end] <= max) {
            return end;
        } else if (scores[start] <= max) {
            return start;
        }
        
        return -1;
    }
}


// List<Integer> h = new ArrayList<>(height);
// Collections.sort(h);

// int count = 0;
// for (int i = 0; i < height.size(); i++) {
//     if (h.get(i) != height.get(i)) {
//         count++;
//     }
// }
// return count;