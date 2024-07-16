class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            int count = 0;
            while (i < n && nums[i] == 1) {
                count++;
                i++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}