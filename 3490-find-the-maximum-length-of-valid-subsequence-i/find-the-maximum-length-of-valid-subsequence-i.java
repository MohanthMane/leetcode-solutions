// odd + odd and even + even
// odd + even
class Solution {
    public int maximumLength(int[] nums) {
        int oddCount = 0, evenCount = 0;
        int oddEven = 0, parity = nums[0] % 2;
        for (int num: nums) {
            if (num % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
            if (num % 2 == parity) {
                oddEven++;
                parity = 1 - parity;
            }
        }
        int allOdds = oddCount;
        int allEven = evenCount;
        return Math.max(oddEven, Math.max(allOdds, allEven));
    }
}