class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n + 1];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], something -> new ArrayList<>()).add(new Edge(flight[1], flight[2]));
        }

        // [Distance, Node, Steps]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, src});
        int stops = 0;
        while (stops <= k && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int currentDist = current[0];
                int currentNode = current[1];

                for (Edge edge : graph.getOrDefault(currentNode, new ArrayList<>())) {
                    int newDist = currentDist + edge.dist;
                    if (newDist < prices[edge.node]) {
                        prices[edge.node] = newDist;
                        queue.offer(new int[] {newDist, edge.node});
                    }
                }
            }
            stops++;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}

class Edge {
    int node;
    int dist;

    public Edge(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}