import java.util.*;

public class KEmptySpots {
	public static void main(String[] args) {
		System.out.println(kEmptySlots(new int[]{1, 3, 2}, 1));
    }
 
    private static  int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		int day = 0;

		for (Integer flower : flowers) {
			set.add(flower);
			day++;
			
			Integer higher = set.higher(flower);
			Integer lower = set.lower(flower);

			if (lower != null && flower - lower - 1 == k ||
					higher != null && higher - flower - 1 == k) {
					return day;
				}
		}

		return -1;
	}
}