class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int maxEnd = 0;
        for (int[] interval: intervals) {
            maxEnd = Math.max(maxEnd, interval[1]);
        }
        int[] line = new int[maxEnd + 1];
        for (int[] interval: intervals) {
            line[interval[0]]++;
            line[interval[1]]--;
        }

        int result = 0, active = 0;
        for (int i = 0; i < line.length; i++) {
            active += line[i];
            result = Math.max(result, active);
        }
        return result;
    }
}