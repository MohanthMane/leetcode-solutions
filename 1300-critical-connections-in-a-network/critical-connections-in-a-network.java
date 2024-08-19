class Solution {

    private int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> connection: connections) {
            int a = connection.get(0), b = connection.get(1);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] seen = new boolean[n];
        int[] discovery = new int[n], lowest = new int[n];
        dfs(0, -1, graph, bridges, discovery, lowest, seen);
        return bridges;
    }

    private void dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<List<Integer>> bridges, int[] discovery, int[] lowest, boolean[] seen) {
        seen[node] = true;
        discovery[node] = lowest[node] = timer;
        timer++;
        for (Integer neighbor: graph.getOrDefault(node, new ArrayList<>())) {
            if (neighbor == parent) continue;
            if (!seen[neighbor]) {
                dfs(neighbor, node, graph, bridges, discovery, lowest, seen);
                lowest[node] = Math.min(lowest[node], lowest[neighbor]);

                if (lowest[neighbor] > discovery[node]) {
                    bridges.add(List.of(neighbor, node));
                }
            } else {
                lowest[node] = Math.min(lowest[node], lowest[neighbor]);
            }
        }
    }
}