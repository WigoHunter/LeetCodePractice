import java.util.*;

public class PlusOneLinkedList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		ListNode head = new ListNode(9);
		head.next = new ListNode(9);
		head.next.next = new ListNode(9);
		ListNode res = plusOne(head);

		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
    }
 
    private static ListNode plusOne(ListNode head) {
		ListNode cur = head;
        while (cur.next != null) {
			cur = cur.next;
		}

		cur.val++;
		mathProcess(head);

		if (head.val >= 10) {
			ListNode newHead = new ListNode(1);
			head.val %= 10;
			newHead.next = head;
			return newHead;
		}

		return head;
	}
	
	private static void mathProcess(ListNode node) {
		if (node.next != null) {
			mathProcess(node.next);
			if (node.next.val >= 10) {
				node.next.val %= 10;
				node.val++;
			}
		}
	}
}