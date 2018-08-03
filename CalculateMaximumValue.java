import java.util.*;

public class CalculateMaximumValue {
	public static void main(String[] args) {
		System.out.println(calcMaxValue("198"));
    }
 
    private static int calcMaxValue(String str) {
		int max = 0;

		for (char c : str.toCharArray()) {
			int num = c - '0';
			max = Math.max(max + num, max * num);
		}

		return max;
	}
}