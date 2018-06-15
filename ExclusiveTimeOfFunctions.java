import java.util.*;

public class ExclusiveTimeOfFunctions {
	private static class Log {
		int func;
		String status;
		int time;
		Log(String s) {
			func = Integer.valueOf(s.substring(0, s.indexOf(":")));
			status = s.substring(s.indexOf(":") + 1, s.indexOf(":", s.indexOf(":") + 1));
			time = Integer.valueOf(s.substring(1 + s.indexOf(":", s.indexOf(":") + 1)));
		}
	}

    public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("0:start:0");
		list.add("0:start:2");
		list.add("0:end:5");
		list.add("0:end:6");

		System.out.println(Arrays.toString(exclusiveTime(2, list)));
	}

	private static int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];
		Stack<Integer> funcs = new Stack<>();
		int curTime = 0;

		for (String s : logs) {
			Log log = new Log(s);
			if (!funcs.isEmpty())
				res[funcs.peek()] += log.time - curTime;
			
			curTime = log.time;
			if (log.status.equals("start"))
				funcs.push(log.func);
			else {
				res[funcs.pop()]++;
				curTime++;
			}
		}

		return res;
	}
}