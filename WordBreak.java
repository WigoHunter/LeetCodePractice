import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
		List<String> dic = Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"});
		System.out.println(wordBreakSolution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dic));
	}

	private static boolean wordBreakSolution(String s, List<String> wordDict) {
		boolean[] bools = new boolean[s.length() + 1];
		bools[0] = true;

		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (bools[j] && wordDict.contains(s.substring(j, i))) {
					bools[i] = true;
					break;
				}
			}
		}

		return bools[s.length()];
	}

	private static boolean wordBreak(String s, List<String> wordDict) {
		StringBuilder sb = new StringBuilder();

		if (s.length() == 0) 	return true;
		
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));

			if (wordDict.contains(sb.toString())) {
				System.out.println("" + sb.toString() + " " + s.substring(i + 1));
				if (wordBreak(s.substring(i + 1), wordDict)) {
					return true;
				}
			}
		}

		return false;
	}
}