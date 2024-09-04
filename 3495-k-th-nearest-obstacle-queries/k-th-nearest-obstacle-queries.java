class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(a -> -a));
        int[] result = new int[queries.length];
        int idx = 0;
        for (int[] query: queries) {
            int dist = Math.abs(query[0]) + Math.abs(query[1]);
            queue.offer(dist);
            if (queue.size() > k) {
                queue.poll();
            }
            if (queue.size() == k) {
                result[idx] = queue.peek();
            } else {
                result[idx] = -1;
            }
            idx++;
        }
        return result;
    }
}