class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeSet<Interval> intervals = new TreeSet<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                // Compare by start time to maintain TreeSet order
                if (i1.start != i2.start) {
                    return Integer.compare(i1.start, i2.start);
                }
                // If start times are the same, compare by end time
                return Integer.compare(i1.end, i2.end);
            }
        });

        for (List<Interval> employee: schedule) {
            for (Interval employeeSchedule: employee) {
                addInterval(intervals, employeeSchedule);
            }
        }
        List<Interval> result = new ArrayList<>();
        Interval prev = null;
        for (Interval interval : intervals) {
            if (prev != null && prev.end < interval.start) {
                result.add(new Interval(prev.end, interval.start));
            }
            prev = interval;
        }
        return result;
    }

    private void addInterval(TreeSet<Interval> intervals, Interval interval) {
        Interval newInterval = new Interval(interval.start, interval.end);
        Interval lower = intervals.lower(newInterval);
        Interval higher = intervals.higher(newInterval);

        if (lower != null && lower.end >= interval.start) {
            newInterval.start = Math.min(newInterval.start, lower.start);
            newInterval.end = Math.max(newInterval.end, lower.end);
            intervals.remove(lower);
        }

        while (higher != null && higher.start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, higher.start);
            newInterval.end = Math.max(newInterval.end, higher.end);
            intervals.remove(higher);
            higher = intervals.higher(newInterval);
        }

        intervals.add(newInterval);
    }
}
