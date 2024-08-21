class TreeAncestor {

    /*
        dp state: dp[i][j] = j-th node's 2^(i)th ancestor in the path 
        dp init: dp[i][j] = dp[0][j] (first parent (2^0) of each node is given)
        Formula : dp[i][j] = dp[i-1][dp[i-1][j]]
    */
    private int[][] dp;
    private int maxDepth;

    public TreeAncestor(int n, int[] parent) {
        this.maxDepth = (int) (Math.log(n) / Math.log(2)) + 1;
        this.dp = new int[maxDepth][n];
        dp[0] = parent;

        for (int i = 1; i < maxDepth; i++) {
            for (int node = 0; node < n; node++) {
                int preAncestor = dp[i - 1][node];
                // No more ancestors
                if (preAncestor == -1) {
                    dp[i][node] = -1;
                } else {
                    dp[i][node] = dp[i - 1][preAncestor];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int currNode = node;
        for (int i = 0; i < maxDepth; i++) {
            if (((k >> i) & 1) == 1) {
                currNode = dp[i][currNode];
            }
            if (currNode == -1) return -1;
        }
        return currNode;
    }
}
