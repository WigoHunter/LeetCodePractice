import java.util.*;

public class ReverseLinkedList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);

		ListNode res = reverse(root);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	private static ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode next;
		ListNode newHead = head.next;
		head.next = null;

		while (newHead.next != null) {
			next = newHead.next;
			newHead.next = head;
			head = newHead;
			newHead = next;
		}

		newHead.next = head;
		return newHead;
	}
	
	private static ListNode reverseList(ListNode head) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		Stack<ListNode> stack = new Stack<>();

		while (head != null) {
			stack.push(head);
			head = head.next;
		}

		while (!stack.isEmpty()) {
			cur.next = stack.pop();
			cur = cur.next;
		}

		cur.next = null;
		return res.next;
	}
}