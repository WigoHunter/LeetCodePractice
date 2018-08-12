import java.util.*;

public class GroupAnagramsII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(groupAnagrams(new String[]{
            "eat", "tea", "tan", "ate", "nat", "bat"
        }).toArray()));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
			String key = new String(chars);
			List<String> list = map.getOrDefault(key, new ArrayList<>());
			list.add(s);
			map.put(key, list);
		}
		
		List<List<String>> res = new ArrayList<>();
		res.addAll(map.values());
		return res;
    }
}