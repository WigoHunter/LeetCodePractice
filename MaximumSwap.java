import java.util.*;

public class MaximumSwap {
    public static void main(String[] args) {
		System.out.println(maximumSwap(9973));
	}

	private static int maximumSwap(int num) {
		char[] chars = String.valueOf(num).toCharArray();
		Map<Integer, Integer> charLastPos = new HashMap<>();

		for (int i = 0; i < chars.length; i++) {
			charLastPos.put(chars[i] - '0', i);
		}

		for (int i = 0; i < chars.length; i++) {
			int cur = chars[i] - '0';
			for (int j = 9; j > cur; j--) {
				if (charLastPos.getOrDefault(j, -1) > i) {
					char temp = chars[i];
					chars[i] = chars[charLastPos.get(j)];
					chars[charLastPos.get(j)] = temp;
					return Integer.valueOf(String.valueOf(chars));
				}
			}
		}

		return Integer.valueOf(String.valueOf(chars));
	}
}