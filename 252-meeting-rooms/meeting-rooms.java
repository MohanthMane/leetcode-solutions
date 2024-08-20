class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[1]));
        int maxTime = 0;
        for (int[] interval: intervals) {
            maxTime = Math.max(maxTime, interval[1]);
        }
        int[] line = new int[maxTime + 1];
        for (int[] interval: intervals) {
            line[interval[0]]++;
            line[interval[1]]--;
        }

        int sum = 0;
        for (int i = 0; i < line.length; i++) {
            sum += line[i];
            if (sum > 1) return false;
        }
        return true;
    }
}