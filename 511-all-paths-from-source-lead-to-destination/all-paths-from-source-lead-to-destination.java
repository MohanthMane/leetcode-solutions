class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        
        // This is to handle cycles. If we visit the parent before child is set
        // to true, then it is a cycle
        Boolean[] states = new Boolean[n];
        return dfs(source, destination, graph, states);
    }
    
    private boolean dfs(int source, int destination, Map<Integer, List<Integer>> graph, Boolean[] states) {
        if (states[source] != null) return states[source];
        if (graph.getOrDefault(source, new ArrayList<>()).size() == 0) {
            return source == destination;
        }
        
        states[source] = false;
        for (int neighbor: graph.getOrDefault(source, new ArrayList<>())) {
            if (!dfs(neighbor, destination, graph, states)) return false;
        }
        states[source] = true;
        return true;
    }
}