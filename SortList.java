import java.util.*;

public class SortList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(3);

		printList(sortList(node));
	}

	private static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)	return head;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = slow.next;
		slow.next = null;
		slow = head;

		return merge(sortList(slow), sortList(fast));
	}

	private static ListNode merge(ListNode l, ListNode r) {
		if (l == null)	return r;
		if (r == null)	return l;

		ListNode node = new ListNode(0);
		ListNode cur = node;

		while (l != null && r != null) {
			if (l.val < r.val) {
				cur.next = l;
				l = l.next;
			} else {
				cur.next = r;
				r = r.next;
			}

			cur = cur.next;
		}

		if (l != null)	cur.next = l;
		if (r != null)	cur.next = r;

		return node.next;
	}

	private static void printList(ListNode node) {
		ListNode cur = node;
		while (cur != null){
			System.out.print("" + cur.val + " ");
			cur = cur.next;
		}

		System.out.println("");
	}
}