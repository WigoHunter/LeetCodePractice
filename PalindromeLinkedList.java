import java.util.*;

public class PalindromeLinkedList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(1);

		System.out.println(isPalindrome(root));
    }
 
	private static boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (slow.val != fast.val) {
				return false;
			}

			slow = slow.next;
			fast = fast.next;
		}

		return true;
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}
}