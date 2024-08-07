class Solution {

    private final int[][] rectangles;
    private final TreeMap<Integer, Integer> map;
    private int sum = 0;
    private final Random random;


    public Solution(int[][] rects) {
        this.rectangles = rects;
        this.map = new TreeMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            sum += getArea(rectangles[i]);
            map.put(sum, i);
        }
        this.random = new Random();
    }

    public int[] pick() {
        int randomRectIdx = map.ceilingKey(random.nextInt(1, sum + 1));
        int[] rectangle = rectangles[map.get(randomRectIdx)];
        return new int[]{random.nextInt(rectangle[0], rectangle[2] + 1), random.nextInt(rectangle[1], rectangle[3] + 1)};
    }

    private int getArea(int[] rectangle) {
        return (rectangle[2] - rectangle[0] + 1) * (rectangle[3] - rectangle[1] + 1);
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */