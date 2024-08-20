class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] line = new int[length + 1];
        for (int[] update: updates) {
            line[update[0]] += update[2];
            line[update[1] + 1] -= update[2];
        }

        int[] result = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += line[i];
            result[i] = sum;
        }
        return result;
    }
}