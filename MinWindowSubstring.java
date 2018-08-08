import java.util.*;

public class MinWindowSubstring {
    public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
    
    private static String minWindow(String s, String t) {
		int min = Integer.MAX_VALUE;
		String res = "";

		int[] targets = new int[256];
		int numOfTargets = 0;

		for (char c : t.toCharArray()) {
			numOfTargets++;
			targets[c]++;
		}

		int count = 0;
		int i = 0;
		int j = 0;

		for (i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if (targets[cur] > 0) {
				count++;
			}

			targets[cur]--;

			while (count >= numOfTargets) {
				if (i - j + 1 < min) {
					min = i - j + 1;
					res = s.substring(j, i + 1);
				}

				targets[s.charAt(j)]++;
				if (targets[s.charAt((j))] > 0) {
					count--;
				}

				j++;
			}
		}

		return res;
	}
}