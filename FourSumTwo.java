import java.util.*;

public class FourSumTwo {

    public static void main(String[] args) {
		int answer = _fourSumSolution(
			new int[]{1, 2},
			new int[]{-2, -1},
			new int[]{-1, 2},
			new int[]{0, 2}
		);

        System.out.println(answer);
    }
 
    private static int _fourSumSolution(int[] A, int[] B, int[] C, int[] D) {
		int res = 0;
		int sum;
		Map<Integer, Integer> sumCount = new HashMap<>();
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				sum = A[i] + B[j];
				sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
			}
		}

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				sum = C[i] + D[j];
				res += sumCount.getOrDefault((-1 * sum), 0);
			}
		}

		return res;
    }
}