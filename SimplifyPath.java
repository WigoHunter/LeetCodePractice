import java.util.*;

public class SimplifyPath {
   	public static void main(String[] args) {
		System.out.println(simplifyPath("/home"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/a//c/"));
    }
 
    private static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();

		for (String s : path.split("/")) {
			if (s.equals(".")) {
				continue;
			} else if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (s.length() > 0) {
				stack.push(s);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.pop());
		}

		return sb.length() == 0 ? "/" : sb.toString();
    }
}