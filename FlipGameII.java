import java.util.*;

public class FlipGameII {
    public static void main(String[] args) {
		System.out.println(canWin("+-++-+++-++++-+++++-+-+-+-+-+-+-+-+-+-+-+"));
	}

	private static boolean canWin(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.substring(i, i + 2).equals("++")) {
				if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean cantWin(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.substring(i, i + 1).equals("++")) {
				return false;
			}
		}

		return true;
	}
}