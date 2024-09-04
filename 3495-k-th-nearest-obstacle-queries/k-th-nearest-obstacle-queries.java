class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> -a[2]));
        int[] result = new int[queries.length];
        int idx = 0;
        for (int[] query: queries) {
            int x = query[0], y = query[1], dist = Math.abs(x) + Math.abs(y);
            queue.offer(new int[]{x, y, dist});
            if (queue.size() > k) {
                queue.poll();
            }
            if (queue.size() == k) {
                result[idx] = queue.peek()[2];
            } else {
                result[idx] = -1;
            }
            idx++;
        }
        return result;
    }
}