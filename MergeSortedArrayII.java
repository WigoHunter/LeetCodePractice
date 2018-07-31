import java.util.*;

public class MergeSortedArrayII {
    public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
		int[] nums2 = new int[]{2, 5, 6};
		merge(nums1, 3, nums2, 3);

		System.out.println(Arrays.toString(nums1));
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index1 = m - 1;
		int index2 = n - 1;
		int index = m + n - 1;

		while (index1 >= 0 && index2 >= 0) {
			if (nums1[index1] > nums2[index2]) {
				nums1[index--] = nums1[index1--];
			} else {
				nums1[index--] = nums2[index2--];
			}
		}

		while (index1 >= 0) {
			nums1[index--] = nums1[index1--];
		}

		while (index2 >= 0) {
			nums1[index--] = nums2[index2--];
		}
	}
}