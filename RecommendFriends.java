import java.util.*;

public class RecommendFriends {

    public static void main(String[] args) {
		System.out.println(recommendFriends(new int[][]{
			{1},
			{0},
			{3},
			{2}
		}, 1));
    }
 
	private static int recommendFriends(int[][] friends, int user) {
		Set<Integer> set = new HashSet<>();
		for (int i : friends[user]) {
			set.add(i);
		}

		int max = 0;
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < friends.length; i++) {
			if (i == user || set.contains(i)) {
				continue;
			}

			int count = 0;
			for (int num : friends[i]) {
				if (set.contains(num)) {
					count++;
				}
			}

			if (count == 0)	continue;
			if (count > max) {
				max = count;
				res = i;
			} else if (count == max && i < res) {
				res = i;
			}
		}

		if (res == Integer.MAX_VALUE) {
			return -1;
		}

		return res;
	}
}