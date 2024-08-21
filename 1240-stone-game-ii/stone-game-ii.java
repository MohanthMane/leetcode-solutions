class Solution {

    private Map<String, Integer> dp = new HashMap<>();

    public int stoneGameII(int[] piles) {
        int[] prefixSum = new int[piles.length];
        prefixSum[0] = piles[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + piles[i];
        }
        return solve(piles, 0, true, prefixSum, 1);
    }

    private int solve(int[] piles, int start, boolean isAlice, int[] prefixSum, int M) {
        if (start == piles.length) return 0;

        String key = isAlice + "_" + start + "_" + M;
        if (dp.containsKey(key)) return dp.get(key);
        
        int result = 0;
        if (!isAlice) result = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            int endIdx = start + x - 1;
            if (endIdx >= piles.length) break;
            int toSubtract = (start == 0) ? 0 : prefixSum[start - 1];
            int score = prefixSum[endIdx] - toSubtract;

            if (isAlice) {
                result = Math.max(result, score + solve(piles, start + x, !isAlice, prefixSum, Math.max(M, x)));
            } else {
                result = Math.min(result, solve(piles, start + x, !isAlice, prefixSum, Math.max(M, x)));
            }
        }
        dp.put(key, result);
        return result;
    }
}
