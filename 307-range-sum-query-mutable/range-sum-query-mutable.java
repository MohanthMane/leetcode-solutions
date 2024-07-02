class NumArray {

    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4 * n];
        buildTree(nums, 0, n - 1, 1);
    }

    private void buildTree(int[] nums, int l, int r, int root) {
        if (l == r) {
            tree[root] = nums[l];
        } else {
            int mid = (l + r) / 2;
            buildTree(nums, l, mid, 2 * root);
            buildTree(nums, mid + 1, r, 2 * root + 1);
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    private void updateTree(int l, int r, int root, int index, int newValue) {
        if (l == r) {
            tree[root] = newValue;
        } else {
            int mid = (l + r) / 2;
            if (index <= mid) {
                updateTree(l, mid, 2 * root, index, newValue);
            } else {
                updateTree(mid + 1, r, 2 * root + 1, index, newValue);
            }
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    private int getSum(int start, int end, int root, int l, int r) {
        if (start > r || end < l) return 0;
        if (l >= start && r <= end) return tree[root];

        int mid = (l + r) / 2;
        return getSum(start, end, 2 * root, l, mid) + getSum(start, end, 2 * root + 1, mid + 1, r);
    }
    
    public void update(int index, int val) {
        updateTree(0, n - 1, 1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return getSum(left, right, 1, 0, n - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */