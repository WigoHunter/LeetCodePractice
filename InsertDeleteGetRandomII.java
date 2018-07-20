import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

class RandomizedSet {
	Map<Integer, LinkedList<Integer>> locations;
	List<Integer> list;
	Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
		locations = new HashMap<>();
		list = new ArrayList<>();
		r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!locations.containsKey(val)) {
			LinkedList<Integer> q = new LinkedList<>();
			q.offer(list.size());
			list.add(val);
			locations.put(val, q);
			return true;
		}

		locations.get(val).offer(list.size());
		list.add(val);
		return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
		if (!locations.containsKey(val)) {
			return false;
		}

		LinkedList<Integer> q = locations.get(val);
		int pos = q.getLast();
		q.removeLast();

		if (pos != list.size() - 1) {
			int last = list.get(list.size() - 1);
			locations.get(last).remove(new Integer(list.size() - 1));
			locations.get(last).addLast(pos);
			list.set(pos, last);
			list.remove(list.size() - 1);
		} else {
			locations.get(val).remove(new Integer(list.size() - 1));
			list.remove(pos);
		}

		if (locations.get(val).isEmpty()) {
			map.remove(val);
		}

		return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
