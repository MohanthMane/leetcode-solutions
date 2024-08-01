class NumArray {

    private int[] fenwick;
    private int[] nums;
    private int n;

    // Striver video on fenwick trees
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.fenwick = new int[n + 1];
        for (int i = 0; i < n; i++) {
            updateFenwick(i, nums[i]);
        }
    }

    private void updateFenwick(int index, int val) {
        int i = index + 1;
        while (i <= n) {
            fenwick[i] += val;
            i = i + (i & -i); // 2's complement, AND with self, Add with self
        }
    }

    private int getSum(int end) {
        int i = end + 1;
        int sum = 0;
        while (i > 0) {
            sum += fenwick[i];
            i = i - (i & -i);
        }
        return sum;
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateFenwick(index, diff);
    }
    
    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }
}