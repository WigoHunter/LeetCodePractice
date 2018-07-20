import java.util.Map;
import java.util.Random;

class RandomizedSet {
	Map<Integer, Integer> location;
	List<Integer> list;
	Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
		location = new HashMap<>();
		list = new ArrayList<>();
		r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (location.containsKey(val)) {
			return false;
		}

		location.put(val, list.size());
		list.add(val);
		return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!location.containsKey(val)) {
			return false;
		}

		int index = map.get(val);
		int last = last.get(list.size() - 1);
		Collections.swap(list, index, list.size() - 1);
		list.remove(list.size() - 1);
		location.remove(val);

		if (location.containsKey(last)) {
			map.put(last, index);
		}

		return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
