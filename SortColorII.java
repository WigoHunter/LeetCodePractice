import java.util.*;

public class SortColorII {
    public static void main(String[] args) {
		int[] colors = new int[]{3, 2, 2, 1, 4};
		sortColors2(colors, 4);

		System.out.println(Arrays.toString(colors));
	}
	
	private static void sortColors2(int[] colors, int k) {
		if (colors == null || colors.length == 0 || colors.length == 1) {
			return;
		}

		rainbowSort(colors, 0, colors.length - 1, 1, k);
	}

	private static void rainbowSort(int[] colors, int left, int right, int from, int to) {
		if (from == to || left >= right)	return;

		int mid = from + (to - from) / 2;
		int l = left;
		int r = right;

		while (l <= r) {
			while (l <= r && colors[l] <= mid) {
				l++;
			}

			while (l <= r && colors[r] > mid) {
				r--;
			}

			if (l <= r) {
				int temp = colors[l];
				colors[l] = colors[r];
				colors[r] = temp;
				l++;
				r--;

			
			}
		}

		rainbowSort(colors, left, r, from, mid);
		rainbowSort(colors, l, right, mid + 1, to);
	}
	
}