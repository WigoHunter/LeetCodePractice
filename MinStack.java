import java.util.*;

public class MinStack {
	public static class MStack {
		Stack<Integer> stack;
		Stack<Integer> mins;

		public MStack() {
			stack = new Stack<>();
			mins = new Stack<>();
		}

		public void push(int x) {
			stack.push(x);
			if (mins.isEmpty() || x <= mins.peek()) {
				mins.push(x);
			}
		}
		
		public void pop() {
			if (stack.peek() == mins.peek()) {
				mins.pop();
			}
			stack.pop();
		}
		
		public int top() {
			return stack.peek();
		}
		
		public int getMin() {
			return mins.peek();
		}
	}

    public static void main(String[] args) {
		MStack stack = new MStack();
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.getMin());
	}
}