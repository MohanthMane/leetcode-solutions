class RangeModule {

    private TreeSet<Interval> ranges;

    public RangeModule() {
        this.ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> iterator = ranges.tailSet(new Interval(0, left)).iterator();
        while (iterator.hasNext()) {
            Interval interval = iterator.next();
            if (right < interval.start) {
                break;
            }
            left = Math.min(left, interval.start);
            right = Math.max(right, interval.end);
            iterator.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval interval = ranges.higher(new Interval(0, left));
        return interval != null && interval.start <= left && interval.end >= right;
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> iterator = ranges.tailSet(new Interval(0, left)).iterator();
        List<Interval> toAdd = new ArrayList<>();
        while (iterator.hasNext()) {
            Interval interval = iterator.next();
            if (right <= interval.start) {
                break;
            }
            if (interval.start < left) {
                toAdd.add(new Interval(interval.start, left));
            }
            if (interval.end > right) {
                toAdd.add(new Interval(right, interval.end));
            }
            iterator.remove();
        }
        ranges.addAll(toAdd);
    }
}

class Interval implements Comparable<Interval> {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval that) {
        if (this.end == that.end) {
            return this.start - that.start;
        }
        return this.end - that.end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}