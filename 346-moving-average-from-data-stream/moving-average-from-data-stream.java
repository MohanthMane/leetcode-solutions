class MovingAverage {

    private final Deque<Integer> q;
    private final int size;
    private int sum;

    public MovingAverage(int size) {
        this.size = size;
        this.q = new ArrayDeque<>();
        this.sum = 0;
    }
    
    public double next(int val) {
        if (q.size() == size) {
            int removedVal = q.removeFirst();
            sum -= removedVal;
        }
        sum += val;
        q.addLast(val);
        return (double) ((double) sum / q.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */