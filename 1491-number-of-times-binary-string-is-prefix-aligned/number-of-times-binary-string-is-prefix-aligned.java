class Solution {
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length, result = 0, rightMostOne = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            rightMostOne = Math.max(rightMostOne, flips[i]);
            sum += flips[i];
            long expectedSum = ((long) rightMostOne * (rightMostOne + 1)) / 2;
            if (sum == expectedSum) {
                result++;
            }
        }
        return result;
    }
}