import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(groupAnagrams(new String[]{
            "eat", "tea", "tan", "ate", "nat", "bat"
        }).toArray()));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            List<String> temp = map.getOrDefault(String.valueOf(cs), new ArrayList<String>());
            temp.add(s);
            map.put(String.valueOf(cs), temp);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }

        return res;
    }
}