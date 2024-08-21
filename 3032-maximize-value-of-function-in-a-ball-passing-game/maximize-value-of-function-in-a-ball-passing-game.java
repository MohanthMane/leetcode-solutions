class Solution {

    private long[][] dp, score;
    private static final int maxDepth = 35;

    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();
        this.dp = new long[n][maxDepth];
        this.score = new long[n][maxDepth];

        for (int i = 0; i < n; i++) {
            dp[i][0] = receiver.get(i);
            score[i][0] = receiver.get(i); // Initialize to the current node itself
        }

        for (int j = 1; j < maxDepth; j++) {
            for (int i = 0; i < n; i++) {
                int prevAncestor = (int) dp[i][j - 1];
                if (prevAncestor == -1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = dp[prevAncestor][j - 1];
                    score[i][j] = score[i][j - 1] + score[prevAncestor][j - 1];
                }
            }
        }

        long result = 0;
        // Try every node. NlogN
        for (int node = 0; node < n; node++) {
            int currNode = node;
            long currScore = node;
            for (int i = 0; i < maxDepth; i++) {
                if (((k >> i) & 1) == 1) {
                    if (currNode == -1) break;
                    currScore += score[currNode][i];
                    currNode = (int) dp[currNode][i];
                }
            }
            result = Math.max(result, currScore);
        }
        return result;
    }
}
