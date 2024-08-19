class Solution {
    public int minNumberOperations(int[] target) {
        int result = target[0];
        for (int i = 1; i < target.length; i++) {
            result += Math.max(0, target[i] - target[i - 1]);
        }
        return result;
    }
}