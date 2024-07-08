class CustomStack {

    private final Deque<Integer> stack;
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.addLast(x);
        }
    }
    
    public int pop() {
        if (stack.isEmpty()) return -1;
        return stack.removeLast();
    }
    
    public void increment(int k, int val) {
        List<Integer> l = new ArrayList<>();
        int count = 0;
        while (count < k && !stack.isEmpty()) {
            l.add(stack.removeFirst() + val);
            count++;
        }
        for (int i = l.size() - 1; i >= 0; i--) {
            stack.addFirst(l.get(i));
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */