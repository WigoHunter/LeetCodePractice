public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            if (nums[right] < k) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            } else {
                right--;
            }
        }
        
        return left;
    }
}