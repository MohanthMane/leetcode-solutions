class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] prefixSum = new int[n][26];
        int[] result = new int[queries.length];

        prefixSum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = Arrays.copyOf(prefixSum[i - 1], 26);
            prefixSum[i][s.charAt(i) - 'a']++;
        }

        int idx = 0;
        for (int[] query: queries) {
            int start = query[0], end = query[1];
            for (int i = 0; i < 26; i++) {
                int count = prefixSum[end][i] - (start == 0 ? 0 : prefixSum[start - 1][i]);
                result[idx] += (count * (count + 1)) / 2;
            }
            idx++;
        }
        return result;
    }
}