import java.util.*;

public class RandomPickIndex {
    private static class Solution {
        Map<Integer, List<Integer>> map;
        Random r;

        public Solution(int[] nums) {
            map = new HashMap<>();
            r = new Random();
            List<Integer> list;

            for (int i = 0; i < nums.length; i++) {
                list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.put(nums[i], list);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.getOrDefault(target, null);
            if (list == null)   return -1;

            return list.get(r.nextInt(list.size()));
        }
    }
}