class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] bucket = new int[n + 1];
        for (int i = 0; i < n; i++) {
            bucket[Math.min(n, nums[i])]++; // Any number > n can be treated as n which will allow us to use bucket sort
        }

        int greaterOrEqual = 0;
        for (int i = n; i >= 0; i--) {
            greaterOrEqual += bucket[i];
            if (i == greaterOrEqual) {
                return i;
            }
        }
        return -1;
    }
}