class CountIntervals {
    
    // Interval treemap start -> finish.
    private final TreeMap<Integer, Integer> s;
    private int count;
    public CountIntervals() {
        this.s = new TreeMap<Integer, Integer>();
        this.count = 0;
    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> floorEntry = s.floorEntry(right);
        if (floorEntry == null || floorEntry.getValue() < left) {
            s.put(left, right);
            count += (right - left + 1);
        } else {
            int start = left;
            int end = right;

            // Remove overlapping intervals and update count.
            while (true) {
                int l = s.floorKey(end);
                int r = s.get(l);
                start = Math.min(start, l);
                end = Math.max(end, r);
                count -= (r - l + 1);
                s.remove(l);
                // Break the loop until there is no overlapping with interval (start, end).
                floorEntry = s.floorEntry(end);
                if (floorEntry == null || floorEntry.getValue() < start) {
                    break;
                }
            }
            // Add (start, end) to TreeMap and update count.
            s.put(start, end);
            count += (end - start + 1);
        }
    }

    public int count() {
        return count;
    }
}