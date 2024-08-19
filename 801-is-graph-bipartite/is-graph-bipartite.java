class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                if (!dfs(graph, color, start, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int currentColor) {
        if (color[node] != -1) {
            return color[node] == currentColor;
        }

        color[node] = currentColor;
        for (int neighbor: graph[node]) {
            if (!dfs(graph, color, neighbor, currentColor ^ 1)) return false;
        }
        return true;
    }
}
