class Solution {

    private final Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private final List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        // Collections.reverse(result);
        return result;
    }

    private void dfs(String airport) {
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            dfs(graph.get(airport).poll());
        }
        result.add(0, airport);
    }
}