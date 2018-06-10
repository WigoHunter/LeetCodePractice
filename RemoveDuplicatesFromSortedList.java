import java.util.*;

public class RemoveDuplicatesFromSortedList {

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);

		head = _removeDuplicatesFromSortedList(head);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
    }
 
    private static ListNode _removeDuplicatesFromSortedList(ListNode head) {
		ListNode cur = head;
		ListNode temp = head;
		
		while (cur != null) {
			while (temp != null && temp.val == cur.val) {
				temp = temp.next;
			}
			
			cur.next = temp;
			cur = cur.next;
		}

		return head;
	}
}