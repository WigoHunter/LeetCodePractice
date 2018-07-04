import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
		int[] nums = new int[]{9,3,2,4,8};

		System.out.println(kthLargest(3, nums));
	}

	private static int kthLargest(int k, int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int pivot = nums[right];
			int index = left;

			for (int i = left; i < right; i++) {
				if (nums[i] > pivot) {
					swap(nums, i, index);
					index++;
				}
			}

			swap(nums, index, right);

			if (index == k - 1) {
				return nums[index];
			} else if (index < k - 1) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}

		return -1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private static int kthLargestElement(int k, int[] nums) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	private static int quickSelect(int[] nums, int left, int right, int k) {
        int l = left, r = right;
        int pivot = nums[l];
        
        while (l <= r) {
            while (l <= r && nums[l] > pivot) {
                l++;
			}
			
			while (l <= r && nums[r] < pivot) {
				r--;
			}

			System.out.println(l);
			System.out.println(r);
			System.out.println();

			if (l <= r) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				l++;
				r--;
			}
		}
		
		if (left + k - 1 <= r) {
			return quickSelect(nums, left, r, k);
		} else if (left + k - 1 >= l) {
			return quickSelect(nums, l, right, k - (l - left));
		} else {
			return nums[r + 1];
		}
    }
	
}