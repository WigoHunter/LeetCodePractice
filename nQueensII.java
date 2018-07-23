public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
     
    private int count = 0;
    
    public int totalNQueens(int n) {
        // write your code here
        List<Integer> cols = new ArrayList<>();
        List<Integer> possibles = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            possibles.add(i);
        }
        
        helper(cols, possibles);
        return count;
    }
    
    private void helper(List<Integer> cols, List<Integer> possibles) {
        if (possibles.size() == 0) {
            count++;
            return;
        }
        
        for (int i = 0; i < possibles.size(); i++) {
            int num = possibles.get(i);
            if (!isValid(cols, num)) {
                continue;
            }
            
            cols.add(num);
            possibles.remove(i);
            helper(cols, possibles);
            possibles.add(i, num);
            cols.remove(cols.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();

		for (int i = 0; i < cols.size(); i++) {
			if (i + cols.get(i) == row + col || i - cols.get(i) == row - col) {
				return false;
			}
		}

		return true;
    }
}