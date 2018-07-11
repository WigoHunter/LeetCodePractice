import java.util.*;

public class LRU {
	public static class LRUCache {
		public class ListNode {
			int key;
			int val;
			ListNode prev;
			ListNode next;

			ListNode(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}

		private int cap;
		private ListNode head;
		private ListNode tail;
		private Map<Integer, ListNode> map;
		
		public LRUCache(int cap) {
			this.cap = cap;
			map = new HashMap<>();
		}

		private void moveToHead(ListNode node) {
			if (node == head || node == null)	return;

			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}

			if (node == tail && node != head) {
				tail = node.prev;
			}
			node.prev = null;
			if (head != null) {
				node.next = head;
				head.prev = node;
			}
			head = node;
		}

		private void evict() {
			if (tail == null) {
				return;
			}

			ListNode target = tail;
			tail = target.prev;
			target.prev = null;

			if (tail != null) {
				tail.next = null;
			}

			if (target == head) {
				head = null;
			}

			map.remove(target.key);
		}

		private void addToHead(ListNode node) {
			if (node == null)	return;

			node.next = head;
			if (head != null) {
				head.prev = node;
			}
			node.prev = null;
			head = node;

			if (tail == null) {
				tail = node;
			}
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}

			ListNode node = map.get(key);
			if (node != head) {
				moveToHead(node);
			}

			return node.val;
		}

		public void put(int key, int value) {
			ListNode node;

			if (map.containsKey(key)) {
				node = map.get(key);
				node.val = value;

				if (node == head)	return;
				moveToHead(node);
			} else {
				node = new ListNode(key, value);

				if (map.size() + 1 > cap) {
					evict();
				}

				addToHead(node);
				map.put(key, node);
			}
		}
	}

   	public static void main(String[] args) {
		
    }
}