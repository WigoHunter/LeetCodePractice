import java.util.*;

public class RearrangeStringWithIntegers {
	
    public static void main(String[] args) {
		System.out.println(rearrange("AC2BEW3"));
	}
    
    private static String rearrange(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		int sum = 0;

		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				sum += (c - '0');
			} else {
				sb.append(c);
			}
		}

		char[] res = sb.toString().toCharArray();
		Arrays.sort(res);

		return new String(res) + sum;
    } 
}