class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = position[position.length - 1] - position[0];
        int result = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(position, mid, m)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] position, int minForce, int balls) {
        int lastPos = Integer.MIN_VALUE;
        for (int pos : position) {
            if (pos - lastPos >= minForce || lastPos == Integer.MIN_VALUE) {
                lastPos = pos;
                balls--;
            }
        }
        return balls <= 0;
    }
}