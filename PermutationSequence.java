import java.util.*;

public class PermutationSequence {
	private static int count = 0;
	private static String str;

    public static void main(String[] args) {
		String res = getPermutation(3, 3);
		System.out.println(res);
	}

	private static String getPermutation(int n, int k) {
		if (n == 0 || k == 0)	return "";

		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(i + 1);
		}

		helper(nums, new StringBuilder(), k);
		return str;
	}

	private static void helper(List<Integer> nums, StringBuilder sb, int k) {
		if (count >= k)	return;
		if (nums.size() == 0) {
			count++;
			if (count == k) {
				str = sb.toString();
			}

			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			sb.append(nums.get(i));
			nums.remove(i);
			helper(nums, sb, k);
			nums.add(i, sb.charAt(sb.length() - 1) - '0');
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}