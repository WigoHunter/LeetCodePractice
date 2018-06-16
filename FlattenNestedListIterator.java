// Problem 341.

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {

    Queue<NestedInteger> q;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        
        for (NestedInteger i : nestedList) {
            q.offer(i);
        }
    }

    @Override
    public Integer next() {
        return q.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!q.isEmpty()) {
            if (q.peek().isInteger()) {
                return true;
            } else {
                List<NestedInteger> temp = q.poll().getList();
                Queue<NestedInteger> tempQ = new LinkedList<>();
                for (NestedInteger i : temp) {
                    tempQ.offer(i);
                }
                tempQ.addAll(q);
                q = tempQ;
            }
        }
        
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */