public class LRUCache {
	private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
	}
	
	private int cap;
	private Map<Integer, Node> map;
	private Node head;
	private Node tail;

	public LRUCache(int cap) {
		this.cap = cap;
		map = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		tail.prev = head;
		head.next = tail;
	}

	public int get(int key) {
		if (!map.contains(key)) {
			return -1;
		}

		Node cur = map.get(key);

		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;

		move_to_tail(cur);
		return map.get(key).value;
	}

	public void set(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}

		if (map.size() == cap) {
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}

		Node insert = new Node(key, value);
		map.put(key, insert);
		move_to_tail(insert);
	}

	private void move_to_tail(Node cur) {
		cur.prev = tail.prev;
		tail.prev = cur;
		cur.prev.next = cur;
		cur.next = tail;
	}
}