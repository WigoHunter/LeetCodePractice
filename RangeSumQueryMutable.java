class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        sums[0] = 0;
        
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        int cur = sums[i + 1] - sums[i];
        int diff = val - cur;
        
        for (int j = i + 1; j < sums.length; j++) {
            sums[j] += diff;
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */