import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(leastInterval(
			new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C'},
			2
		));
    }
 
    private static int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> taskCounts = new HashMap<>();
		int max = 0;
		int count = 0;

		for (char c : tasks) {
			taskCounts.put(c, taskCounts.getOrDefault(c, 0) + 1);
			if (taskCounts.get(c) == max) {
				count++;
			} else if (taskCounts.get(c) > max) {
				max = taskCounts.get(c);
				count = 1;
			}
		}
		
		return Math.max((max - 1) * (n + 1) + count, tasks.length);
    }
}