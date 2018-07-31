import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
		System.out.println(Arrays.toString(mergekSortedArrays(new int[][]{
			{1, 3, 5, 7},
			{2, 4, 6},
			{0, 8, 9, 10, 11}
		})));
	}

	private static int[] mergekSortedArrays(int[][] arrays) {
		if (arrays == null || arrays.length == 0) {
			return new int[]{};
		}

		int end = arrays.length - 1;
		while (end > 0) {
			int index = 0;
			int i = 0;
			
			while (i < end) {
				arrays[index++] = merge(arrays[i], arrays[i + 1]);
				i += 2;
			}

			if (i == end) {
				arrays[index++] = arrays[i];
			}

			end = index - 1;
		}

		return arrays[0];
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
        int l = 0, r = 0, idx = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[idx++] = left[l++];
            } else {
                result[idx++] = right[r++];
            }
        }

        while (l < left.length) {
            result[idx++] = left[l++];
        }

        while (r < right.length) {
            result[idx++] = right[r++];
        }

        return result;
	}
}