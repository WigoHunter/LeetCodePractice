import java.util.*;

public class MultiplyStrings {
	
    public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}

	private static String multiply(String num1, String num2) {
		int l1 = num1.length();
		int l2 = num2.length();
		int temp1, temp2, temp;
		StringBuilder sb = new StringBuilder();
		int[] num = new int[l1 + l2];

		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				temp1 = num1.charAt(i) - '0';
				temp2 = num2.charAt(j) - '0';
				temp = num[i + j + 1] + temp1 * temp2;

				num[i + j] += temp / 10;
				num[i + j + 1] = temp % 10;
			}
		}

		System.out.println(Arrays.toString(num));

		for (int i : num) {
			if (!(sb.length() == 0 && i == 0))
				sb.append(i);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}
}