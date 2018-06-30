import java.util.*;

public class Pow {
    public static void main(String[] args) {
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(4, 2));
	}

	private static double myPow(double x, int n) {
		if (n < 0)	return 1 / pow(x, n * -1);
		return pow(x, n);
	}

	private static double pow(double x, int n) {
		if (n == 0)	return 1.0;
		if (n == 1)	return x;

		double num = pow(x, n / 2);

		if (n % 2 == 0) {
			return num * num;
		} else {
			return num * num * x;
		}
	}
}