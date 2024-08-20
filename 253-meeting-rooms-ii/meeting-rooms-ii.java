class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (int[] interval: intervals) {
            line.put(interval[0], line.getOrDefault(interval[0], 0) + 1);
            line.put(interval[1], line.getOrDefault(interval[1], 0) - 1);
        }

        int result = 0, active = 0;
        for (Map.Entry<Integer, Integer> entry: line.entrySet()) {
            active += entry.getValue();
            result = Math.max(result, active);
        }
        return result;
    }
}