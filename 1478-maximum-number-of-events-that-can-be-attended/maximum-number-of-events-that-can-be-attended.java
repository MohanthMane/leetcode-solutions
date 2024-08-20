class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0, i = 0, n = events.length;
        for (int d = 1; d <= 100000; d++) {
            // Adding end time because we greedily choose the event that ends earlier
            while (i < n && events[i][0] == d) {
                minHeap.add(events[i++][1]);
            }
            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < d) {
                minHeap.poll();
            }

            // Attend
            if (!minHeap.isEmpty()) {
                ans++;
                minHeap.poll();
            }
        }
        return ans;
    }
}