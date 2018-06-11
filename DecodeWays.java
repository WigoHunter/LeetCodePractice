import java.util.*;

public class DecodeWays {

    public static void main(String[] args) {
		System.out.println(_decodeWays("226"));
    }
 
    private static int _decodeWays(String s) {
		// System.out.println(Integer.valueOf("21") - 2);
		if (s.startsWith("0")) return 0;

		if (s.length() > 1) {
			if (Integer.valueOf(s.substring(0, 2)) > 0 && Integer.valueOf(s.substring(0, 2)) <= 26) {
				return _decodeWays(s.substring(1)) + _decodeWays(s.substring(2));
			} else {
				if (s.startsWith("0"))
					return 0;
				return _decodeWays(s.substring(1));
			}
		}

		return 1;
	}
}