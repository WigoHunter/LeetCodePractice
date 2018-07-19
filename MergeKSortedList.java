import java.util.*;

public class MergeKSortedList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);

		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		ListNode node3 = new ListNode(2);
		node3.next = new ListNode(6);

		ListNode[] lists = new ListNode[]{node1, node2, node3};
		ListNode node = mergeKLists(lists);

		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
    
    private static ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> q = new LinkedList<>();
		for (ListNode node : lists) {
			q.offer(node);
		}

		while (q.size() >= 2) {
			ListNode node1 = q.poll();
			ListNode node2 = q.poll();
			ListNode newNode = new ListNode(0);
			ListNode cur = newNode;

			while (node1 != null || node2 != null) {
				if (node1 == null || (node2 != null && node1.val > node2.val)) {
					cur.next = new ListNode(node2.val);
					node2 = node2.next;
				} else {
					cur.next = new ListNode(node1.val);
					node1 = node1.next;
				}
				cur = cur.next;
			}

			q.offer(newNode.next);
		}

		return q.poll();
	}
}