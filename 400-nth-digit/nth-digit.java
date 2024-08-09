class Solution {
    public int findNthDigit(int n) {
        int len = 1; // 1, 2, 3, 4
		long count = 9; // 9, 90, 900, 9000
		int start = 1; // 1, 10, 100, 1000
        while (n > len * count) {
            n -= len * count;
            len++;
            count = count * 10;
            start = start * 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}