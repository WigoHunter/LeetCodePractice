import java.util.*;

public class FastPower {
    public static void main(String[] args) {
		System.out.println(fastPower(109, 10000007, 1000001));
	}

	private static int fastPower(int a, int b, int n) {
		if (n == 0) return 1 % b;
		if (n == 1)	return a % b;

		long temp = fastPower(a, b, n / 2);
		temp = (temp * temp) % b;

		if (n % 2 != 0) {
			temp = (temp * a) % b;
		}

		return (int) temp;
	}
}