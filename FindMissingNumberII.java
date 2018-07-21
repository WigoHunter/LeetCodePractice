import java.util.*;

public class FindMissingNumberII {
    public static void main(String[] args) {
		System.out.println(findMissing2(30, "1110986543271213130292826252423222120191817161514"));
	}
	
	private static int res = 0;

	private static int findMissing2(int n, String str) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		helper(list, str);
		return res;
	}

	private static void helper(List<Integer> nums, String s) {
		if (nums.size() == 1) {
			res = nums.get(0);
			return;
		}

		Integer n1 = null;
		Integer n2 = null;

		if (s.length() > 0)	n1 = Integer.parseInt(s.substring(0, 1));
		if (s.length() > 1) n2 = Integer.parseInt(s.substring(0, 2));

		if (nums.contains(n1)) {
			List<Integer> temp1 = new ArrayList<>(nums);
			temp1.remove(n1);
			helper(temp1, s.substring(1));
		}

		if (n2 != null && nums.contains(n2)) {
			List<Integer> temp2 = new ArrayList<>(nums);
			temp2.remove(n2);
			helper(temp2, s.substring(2));
		}
	}
}