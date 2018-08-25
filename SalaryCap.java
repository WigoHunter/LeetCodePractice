import java.util.*;

public class SalaryCap {
    public static void main(String[] args) {
		List<Integer> salaries = new ArrayList<>();
		salaries.addAll(Arrays.asList(1, 2, 3, 4, 10, 12));

		System.out.println(cap(salaries, 0));
    }

    private static int cap(List<Integer> salaries, int target) {
		int sum = 0;
		int leng = salaries.size();

		if (target == 0) {
			return 0;
		}

		for (int i = 0; i < leng - 1; i++) {
			sum += salaries.get(i);

			if ((target - sum) % (leng - i - 1) == 0) {
				int res = (target - sum) / (leng - i - 1);
				if (res > salaries.get(i) && res <= salaries.get(i + 1)) {
					System.out.println(sum + " " + i);
					return res;
				}
			}
		}

		if (sum + salaries.get(leng - 1) == target) {
			return salaries.get(leng - 1);
		}

		return -1;
	}
}