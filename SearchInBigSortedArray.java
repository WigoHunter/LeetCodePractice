import java.util.*;

public class SearchInBigSortedArray {
	private static class ArrayReader {
		List<Integer> list;

		ArrayReader(int[] nums) {
			list = new ArrayList<>();
			for (int n : nums) {
				list.add(n);
			}
		}

		int get(int index) {
			if (index >= list.size()) {
				return 2147483647;
			} else {
				return list.get(index);
			}
		}
	}

    public static void main(String[] args) {
		System.out.println(searchBigSortedArray(new ArrayReader(new int[]{1,3,6,9,21}), 21));
	}

	private static int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int low = 0;
        int high = 2;
        int mid;
        
        while (reader.get(high) != 2147483647 && reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        
        while (low <= high) {
            mid = (low + high) / 2;
            if (reader.get(mid) == 2147483647) {
                high = mid - 1;
            } else {
                if (reader.get(mid) > target) {
                    high = mid - 1;
                } else if (reader.get(mid) < target) {
                    low = mid + 1;
                } else {
                    while (mid - 1 >= 0 && reader.get(mid) == reader.get(mid - 1))	mid--;
                    return mid;
                }
            }
        }
        
        return -1;
    }
}