class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] line = new int[1000002];
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