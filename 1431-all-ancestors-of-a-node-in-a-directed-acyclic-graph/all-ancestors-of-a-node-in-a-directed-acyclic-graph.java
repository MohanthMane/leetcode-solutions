class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            topologicalOrder.add(currentNode);

            for (int neighbor : graph.get(currentNode)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }


        List<TreeSet<Integer>> ancestorsSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsSetList.add(new TreeSet<>());
        }

        for (int node : topologicalOrder) {
            for (int neighbor : graph.get(node)) {
                ancestorsSetList.get(neighbor).add(node);
                ancestorsSetList.get(neighbor).addAll(ancestorsSetList.get(node));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeSet<Integer> set : ancestorsSetList) {
            result.add(new ArrayList<>(set));
        }
        return result;
    }
}