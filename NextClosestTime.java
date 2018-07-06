import java.util.*;

public class NextClosestTime {
	public static int diff = Integer.MAX_VALUE;
	public static String res = "";

    public static void main(String[] args) {
		System.out.println(nextClosestTime("11:11"));
	}
	
	private static String nextClosestTime(String time) {
		List<Integer> digits = new ArrayList<>();
		
		for (char c : time.toCharArray()) {
			while (c == ':' && digits.size() < 2) {
				digits.add(0, 0);
			}

			if (Character.isDigit(c)) {
				digits.add(c - '0');
			}
		}

		while (digits.size() < 4) {
			digits.add(2, 0);
		}

		int minutes = (digits.get(0) * 10 + digits.get(1)) * 60 + digits.get(2) * 10 + digits.get(3);
		
		dfs(digits, "", minutes);

		return res;
	}

	private static void dfs(List<Integer> digits, String cur, int target) {
		System.out.println(cur);

		if (cur.length() == 4) {
			int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
			 
			int d = m - target > 0 ? m - target : 1440 + m - target;
			if (d < diff) {
				diff = d;
				res = cur.substring(0, 2) + ":" + cur.substring(2, 4);
			}

			return;
		}

		for (int i : digits) {
			if ((cur.length() == 0 && i <= 2)
				|| (cur.length() == 1 && Integer.parseInt(cur) * 10 + i <= 23)
				|| (cur.length() == 2 && i <= 5)
				|| (cur.length() == 3 && Integer.parseInt(cur.substring(2, 3)) * 10 + i <= 59)) {
					dfs(digits, cur + i, target);
				}
		}
	}
}