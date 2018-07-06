import java.util.*;

public class LongestAbsolutePath {

    public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(input));
	}
	
	private static int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int res = 0;

		for (String s : input.split("\n")) {
			int level = s.lastIndexOf('\t') + 1;
			int length = s.length() - level;

			while (stack.size() > level + 1) {
				stack.pop();
			}

			if (s.contains(".")) {
				res = Math.max(res, stack.peek() + length);
			} else {
				stack.push(stack.peek() + length + 1);
			}
		}

		return res;
	}
}