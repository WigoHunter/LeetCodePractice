import java.util.*;

public class MergeKSortedListI {
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

		List<ListNode> lists = new ArrayList<>();
		lists.addAll(Arrays.asList(node1, node2, node3));
		ListNode node = mergeKLists(lists);

		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
    
    private static ListNode mergeKLists(List<ListNode> lists) {
		ListNode root = new ListNode(0);
		Queue<ListNode> pq = new PriorityQueue<>(((a, b) -> a.val - b.val));

		for (ListNode node : lists) {
			if (node != null)
				pq.offer(node);
		}

		ListNode cur = root;
		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			cur.next = temp;
			cur = cur.next;
			
			if (temp.next != null) {
				pq.offer(temp.next);
			}
		}

		return root.next;
	}
}