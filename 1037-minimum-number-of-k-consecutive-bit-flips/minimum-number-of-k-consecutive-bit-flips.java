class Solution {
    public int minKBitFlips(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0, state = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                state = state ^ deque.pollFirst();
            }
            if (state == nums[i]) {
                if (i + k > nums.length) return -1;
                deque.addLast(1);
                state = state ^ 1;
                result++;
            } else {
                deque.addLast(0);
            }
        }
        return result;
    }
}
