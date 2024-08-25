// Errichto's video - https://www.youtube.com/watch?v=oib-XsjFa-M
class TreeAncestor {

    /*
        dp state: dp[i][j] = i-th node's 2^(j)th ancestor in the path 
        dp init: dp[i][j] = dp[i][0] (first parent (2^0) of each node is given)
        Formula : dp[i][j] = dp[dp[i][j - 1]][j - 1]

        To compute kth ancestor, take an example of 19.
        Binary representation will have 16, 2, 1
        If we know the 16th parent, 2nd parent and 1st parent of every node,
        we can compute the ancestor in log n time
    */
    private int[][] dp;
    private int maxDepth;

    public TreeAncestor(int n, int[] parent) {
        this.maxDepth = (int) (Math.log(n) / Math.log(2)) + 1;
        this.dp = new int[n][maxDepth];
        
        for (int i = 0; i < parent.length; i++) {
            dp[i][0] = parent[i];
        }

        for (int j = 1; j < maxDepth; j++) {
            for (int i = 0; i < n; i++) {
                int prevAncestor = dp[i][j - 1];
                if (prevAncestor == -1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = dp[prevAncestor][j - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int currNode = node;
        for (int i = 0; i < maxDepth; i++) {
            if (((k >> i) & 1) == 1) {
                currNode = dp[currNode][i];
            }
            if (currNode == -1) return -1;
        }
        return currNode;
    }
}
