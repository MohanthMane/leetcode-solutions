class RLEIterator {

    private int[] encoding;
    private int iterator;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.iterator = 0;
    }
    
    public int next(int n) {
        int remaining = n;
        for (int i = iterator; i < encoding.length; i+=2) {
            if (encoding[i] < remaining) {
                remaining -= encoding[i];
                encoding[i] = 0;
            } else {
                encoding[i] -= remaining;
                iterator = i;
                return encoding[iterator + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */