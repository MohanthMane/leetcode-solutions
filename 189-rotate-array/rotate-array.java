class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] tail = new int[k];
        int j = 0;
        for (int i = n - k; i < n; i++) {
            tail[j++] = nums[i];
        }
        j = n - k - 1;
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[j--];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tail[i];
        }
    }
}