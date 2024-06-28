class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            if (degree[edge[0]] == n - 1) return edge[0];
            if (degree[edge[1]] == n - 1) return edge[1];
        }
        return -1;
    }
}