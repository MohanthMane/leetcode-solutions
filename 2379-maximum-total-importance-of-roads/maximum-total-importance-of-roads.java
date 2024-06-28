class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);
        long value = 1;
        long result = 0;
        for (int d: degree) {
            result += (d * value);
            value++;
        }
        return result;
    }
}
