import java.util.*;

public class IntegerToEnglishWords {
	public static void main(String[] args) {
		System.out.println(numberToWords(111120));
    }
 
    private static String numberToWords(int num) {
		StringBuilder sb = convertHundred(num % 1000);
		String[] v = new String[]{"Thousand", "Million", "Billion"};

		for (int i = 0; i < 3; i++) {
			num /= 1000;
			sb.insert(0, num % 1000 > 0 ? convertHundred(num % 1000) + " " + v[i] + " " : "");
		}

		return sb.length() == 0 ? "Zero" : sb.toString();
	}

	private static StringBuilder convertHundred(int num) {
		String[] v1 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] v2 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
		StringBuilder sb = new StringBuilder();

		int a = num / 100;
		int b = num % 100;
		int c = num % 10;

		sb.append(b < 20 ? v1[b] : v2[b / 10] + (c > 0 ? " " : "") + v1[c]);

		if (a > 0) {
			sb.insert(0, v1[a] + " Hundred ");
		}

		return sb;
	}
}