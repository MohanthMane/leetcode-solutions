class CountIntervals {
    
    TreeSet<Interval> intervals;
    int count;
    
    public CountIntervals() {
        intervals = new TreeSet<>(new Comparator<Interval>() {
           public int compare(Interval left, Interval right) {
               if (left.right == right.right) {
                   return left.left - right.left;
               }
               return left.right - right.right;
           } 
        });
    }
    
    public void add(int left, int right) {
        Interval searchInterval = new Interval(0, left);
        int start = left;
        int end = right;
        Iterator<Interval> itr = intervals.tailSet(searchInterval).iterator();
        while (itr.hasNext()) {
            Interval current = itr.next();
            if (left <= current.right && right >= current.left) {
                start = Math.min(start, current.left);
                end = Math.max(end, current.right);
                count -= current.right - current.left + 1;
                itr.remove();
            } else {
                break;
            }
        }
        intervals.add(new Interval(start, end));
        count += end - start + 1;
    }
    
    public int count() {      
        return count;
    }
}

class Interval {
    int left, right;

    public Interval(int l, int r) {
        this.left = l;
        this.right = r;
    }
}