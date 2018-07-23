public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i - 1])	continue;
			
            list.add(nums[i]);
            helper(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}