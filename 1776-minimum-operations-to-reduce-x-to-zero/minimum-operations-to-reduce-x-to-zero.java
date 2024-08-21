class Solution {
    public int minOperations(int[] nums, int x) {
        // Find largest subarray with sum = totalSum - x
        int target = Arrays.stream(nums).sum() - x;
        int left = 0, maxLength = -1, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}