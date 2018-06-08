import java.util.Arrays;
import java.util.List;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = _threeSumSolution(new int[]{-1, 0, 1, 2, -1});
        
        System.out.println(Arrays.toString(list.toArray()));
    }
 
    private static List<List<Integer>> _threeSumSolution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int high, low, sum;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                sum = 0 - nums[i];
                low = i + 1;
                high = nums.length - 1;

                while (high > low) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(high > low && nums[low] == nums[low + 1]) low++;
                        while(high > low && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return res;
    }

    /*
    private static List<List<Integer>> _threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                for (int k = 1; k < nums.length - i - j; k++) {
                    if ((nums[i] + nums[i + j] + nums[i + j + k]) == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[i + j]);
                        list.add(nums[i + j + k]);
                        if(!res.contains(list)) res.add(list);
                    }
                }
            }
        }

        return res;
    }
    */
}