import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) {
		System.out.println(climbStairs(45));
	}
	
	private static int climbStairs(int n) {
		if (n <= 3)	return n;

		int[] res = new int[n + 1];
		res[0] = 0;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}

		return res[n];
	}
}