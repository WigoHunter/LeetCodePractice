import java.util.*;

public class ImplementStrstr {
    public static void main(String[] args) {
		System.out.println(strStr(null, "ll"));
	}
	
	private static int strStr(String source, String target) {
		if (target == null || target.isEmpty())	return 0;
		if (source == null || source.isEmpty()) return -1;

		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			if (source.substring(i, i + target.length()).equals(target)) {
				return i;
			}
		}

		return -1;
	}
}