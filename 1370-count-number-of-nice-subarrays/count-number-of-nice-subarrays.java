class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subArraysWithAtMostKOdd(nums, k) - subArraysWithAtMostKOdd(nums, k - 1);
    }

    public int subArraysWithAtMostKOdd(int[] nums, int k) {
        int oddCount = 0, result = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[start] % 2 == 1) {
                    oddCount--;
                }
                start++;
            }
            result += end - start + 1;
        }
        return result;
    }
}