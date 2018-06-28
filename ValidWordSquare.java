import java.util.*;

public class ValidWordSquare {
    public static void main(String[] args) {
		System.out.println(validWordSqaure(new String[]{
			"ball",
			"area",
			"read",
			"lady"
		}));
	}

	private static boolean validWordSqaure(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words[i].length(); j++) {
				if (words[i].charAt(j) != words[j].charAt(i)) {
					return false;
				}
			}
		}

		return true;
	}
}