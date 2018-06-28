import java.util.*;

public class AddStrings {
    public static void main(String[] args) {
		System.out.println(addStrings("999", "1"));
	}

	private static String addStrings(String num1, String num2) {
		int carry = 0, temp;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
			temp = carry + (i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0) + (i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0);

			carry = temp / 10;
			temp %= 10;
			sb.insert(0, temp);
		}

		if (carry == 1)
			sb.insert(0, 1); 

		return sb.toString();
	}
}