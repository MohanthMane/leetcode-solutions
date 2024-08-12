class MyCalendarThree {

    private final TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        this.map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int result = 0, sum = 0;
        for (int val: map.values()) {
            sum += val;
            result = Math.max(result, sum);
        }
        return result;
    }
}