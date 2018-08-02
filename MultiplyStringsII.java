import java.util.*;

public class MultiplyStringsII {
	
    public static void main(String[] args) {
		System.out.println(multiply("0", "0"));
	}

	private static String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}

		int len1 = num1.length();
		int len2 = num2.length();
		int len3 = len1 + len2;
		int[] num = new int[len3];
		int product, carry;
		int i, j;

		for (i = len1 - 1; i >= 0; i--) {
			carry = 0;

			for (j = len2 - 1; j >= 0; j--) {
				product = carry + num[i + j + 1] +
					Character.getNumericValue(num1.charAt(i)) *
					Character.getNumericValue(num2.charAt(j));
				
				num[i + j + 1] = product % 10;
				carry = product / 10;
			}

			num[i + j + 1] = carry;
		}

		StringBuilder sb = new StringBuilder();
		i = 0;

		while (i < len3 - 1 && num[i] == 0) {
			i++;
		}

		while (i < len3) {
			sb.append(num[i++]);
		}

		return sb.toString();
	}
}