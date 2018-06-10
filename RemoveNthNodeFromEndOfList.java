import java.util.*;
import java.util.Map.Entry;

public class RemoveNthNodeFromEndOfList {

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = _removeNthNodeFromEndOfList(head, 2);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
    }
 
    private static ListNode _removeNthNodeFromEndOfList(ListNode head, int n) {
		ListNode cur = head;
		int count = 0;

		while(cur != null) {
			count++;
			cur = cur.next;
		}

		count = count - n;

		if(count == 0)
			return head.next;
		else {
			cur = head;

			while(count > 1) {
				cur = cur.next;
				count--;
			}

			cur.next = cur.next.next;
		}

		return head;
	}
	
	// Two Pointer Solution
	/*
	private static ListNode _twoPointerSolution(ListNode head, int n) {
		ListNode temp = head;
		ListNode cur = head;

		while(n != 0) {
			temp = temp.next;
			n--;
		}

		if (temp == null)
			return head.next;
		else {
			while(temp.next != null) {
				cur = cur.next;
				temp = temp.next;
			}

			cur.next = cur.next.next;
		}

		return head;
	}
	*/
}