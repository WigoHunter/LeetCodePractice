public class Vector2D implements Iterator<Integer> {
    int outerIndex;
    int innerIndex;
    List<List<Integer>> lists;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.lists = vec2d;
        outerIndex = 0;
        innerIndex = -1;
    }

    @Override
    public Integer next() {
        // Write your code here
        innerIndex++;
        if (innerIndex >= lists.get(outerIndex).size()) {
            innerIndex = 0;
            outerIndex++;
            return lists.get(outerIndex).get(innerIndex);
        }
        
        return lists.get(outerIndex).get(innerIndex);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        if (outerIndex < lists.size() - 1) {
            return true;
        }
        
        if (outerIndex == lists.size() - 1) {
            return innerIndex < lists.get(outerIndex).size() - 1;
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */