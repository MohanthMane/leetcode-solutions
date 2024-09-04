class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(a -> -a));
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int dist = Math.abs(query[0]) + Math.abs(query[1]);
            if (queue.size() < k) {
                queue.offer(dist);
            } else if (queue.peek() > dist) {
                queue.poll();
                queue.offer(dist);
            }

            if (queue.size() == k) {
                result[i] = queue.peek();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}