// odd + odd and even + even
// odd + even
class Solution {
    public int maximumLength(int[] nums) {
        int oddCount = 0, evenCount = 0;
        int oddEven = 0, oddEvenParity = 1;
        int evenOdd = 0, evenOddParity = 0;
        for (int num: nums) {
            if (num % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
            if (num % 2 == oddEvenParity) {
                oddEven++;
                oddEvenParity = 1 - oddEvenParity;
            }
            if (num % 2 == evenOddParity) {
                evenOdd++;
                evenOddParity = 1 - evenOddParity;
            }
        }
        return Math.max(Math.max(evenOdd, oddEven), Math.max(oddCount, evenCount));
    }
}