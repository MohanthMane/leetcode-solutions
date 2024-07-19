class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        minHeap.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int startTime = intervals[i][0], endTime = intervals[i][1];
            if (!minHeap.isEmpty() && minHeap.peek() <= startTime) {
                minHeap.poll();
            }
            minHeap.offer(endTime);
        }
        return minHeap.size();
    }
}