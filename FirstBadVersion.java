import java.util.*;

public class FirstBadVersion {

	private static final boolean[] versions = new boolean[]{false, true};

	private static boolean isBadVersion(int i) {
		return versions[i - 1];
	}

    public static void main(String[] args) {
		System.out.println(_firstBadVersion(2));
    }
 
    private static int _firstBadVersion(int n) {
		int start = 1;
		int end = n;
		int mid;

		while (start < end) {
			mid = start + (end - start) / 2;
			if (!isBadVersion(mid))
				start = mid + 1;
			else 
				end = mid;
		}

		return start;
	}
}