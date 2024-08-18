class Solution {
    // In a window of size all 1's, we need to swap all zeros. Find a window with minZeros
    public int minSwaps(int[] data) {
        int windowSize = Arrays.stream(data).sum();
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