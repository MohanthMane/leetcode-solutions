class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length, windowSize = Arrays.stream(nums).sum();
        int[] newNums = new int[n * 2];
        for (int i = 0; i < 2 * n; i++) {
            newNums[i] = nums[i % n];
        }
        return minSwapsNonCircular(newNums, windowSize);
    }

    private int minSwapsNonCircular(int[] data, int windowSize) {
        int count = 0, maxOnes = 0;
        int left = 0, right = 0;

        while (right < data.length) {
            count += data[right];
            if (right - left + 1 > windowSize) {
                count -= data[left++];
            }
            maxOnes = Math.max(maxOnes, count);
            right++;
        }
        return windowSize - maxOnes;
    }
}