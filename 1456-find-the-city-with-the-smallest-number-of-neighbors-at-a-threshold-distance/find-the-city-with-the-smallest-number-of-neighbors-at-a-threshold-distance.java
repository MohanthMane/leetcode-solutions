class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = buildUndirectedGraph(edges);
        Map<Integer, List<Integer>> distances = getSourceToDistancesMap(graph, n);
        System.out.println(distances);
        int resultCity = 0, minReachable = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            int reachable = (int) distances.get(city).stream().filter(distance -> distance <= distanceThreshold).count() - 1;
            if (reachable <= minReachable) {
                minReachable = reachable;
                resultCity = city;
            }
        }
        return resultCity;
    }

    private Map<Integer, List<Integer>> getSourceToDistancesMap(Map<Integer, List<int[]>> graph, int n) {
        Map<Integer, List<Integer>> distances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distances.put(i, dijkstra(graph, i, n));
        }
        return distances;
    }

    private List<Integer> dijkstra(Map<Integer, List<int[]>> graph, int source, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{source, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentDistance = current[1];
            int currentNode = current[0];

            for (int[] neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int newDistance = currentDistance + neighbor[1];
                if (newDistance < distances[neighbor[0]]) {
                    distances[neighbor[0]] = newDistance;
                    queue.offer(new int[]{neighbor[0], newDistance});
                }
            }
        }
        return Arrays.stream(distances).boxed().collect(Collectors.toList());
    }

    public Map<Integer, List<int[]>> buildUndirectedGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], ArrayList::new).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], ArrayList::new).add(new int[]{edge[0], edge[2]});
        }
        return graph;
    }
}