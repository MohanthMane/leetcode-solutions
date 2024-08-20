class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(a -> a[1]));
        int result = 1;
        int prevEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > prevEnd) {
                result++;
                prevEnd = pairs[i][1];
            }
        }
        return result;
    }
}