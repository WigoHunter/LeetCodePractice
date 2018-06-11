import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
		System.out.println(_validParentheses("{[]}"));
    }
 
    private static boolean _validParentheses(String s) {
		if (s.length() == 0) return true;
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		if (s.length() % 2 != 0 || !map.containsKey(s.charAt(0))) return false;

		stack.push(map.get(s.charAt(0)));
		char temp;

		for (int i = 1; i < s.length(); i++) {
			temp = s.charAt(i);

			if (!stack.isEmpty() && stack.peek() == temp) {
				stack.pop();
			} else if (map.containsKey(temp)) {
				stack.push(map.get(temp));
			} else {
				return false;
			}
		}

		return stack.isEmpty();
	}
}