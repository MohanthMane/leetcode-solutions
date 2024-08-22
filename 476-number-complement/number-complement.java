class Solution {
    public int findComplement(int num) {
        int bitLength = (int) (Math.log(num) / Math.log(2)) + 1;
        int bitMask = (1 << bitLength) - 1;
        return num ^ bitMask;
    }
}