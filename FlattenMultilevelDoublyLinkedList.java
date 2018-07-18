import java.util.*;

public class FlattenMultilevelDoublyLinkedList {
	private static class Node {
		int val;
		Node prev;
		Node next;
		Node child;

		Node(){}
		Node(int val, Node prev, Node next, Node child) {
			this.val = val;
			this.prev = prev;
			this.next = next;
			this.child = child;
		}
	}

    public static void main(String[] args) {
		
    }
 
    private static Node flatten(Node head) {
		if (head == null)	return head;
		Node cur = head;

		while (cur != null) {
			if (cur.child == null) {
				cur = cur.next;
				continue;
			}

			Node child = cur.child;
			Node p = child;
			while (p.next != null) {
				p = p.next;
			}

			p.next = cur.next;
			if (cur.next != null) {
				cur.next.prev = p;
			}
			cur.next = child;
			child.prev = cur;
			cur.child = null;

			cur = cur.next;
		}
		
		return head;
	}
}