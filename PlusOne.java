import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
 
    private static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 1) {
                digits[i]++;
                carry = 0;
            }

            if (digits[i] >= 10) {
                digits[i] %= 10;
                carry = 1;
            }

            stack.push(digits[i]);
        }

        int[] res = new int[digits.length + carry];
        int index = 0;
        if (carry == 1) stack.push(1);

        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index++;
        }

        return res;
    }
}