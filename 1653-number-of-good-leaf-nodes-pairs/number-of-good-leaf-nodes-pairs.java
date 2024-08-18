class Solution {

    private int result = 0;

    public int countPairs(TreeNode root, int distance) {
        postOrder(root, distance);
        return result;
    }

    private int[] postOrder(TreeNode root, int distance) {
        if (root == null) return new int[distance + 1];
        if (root.left == null && root.right == null) {
            int[] distances = new int[distance + 1];
            distances[1]++;
            return distances;
        }

        int[] left = postOrder(root.left, distance);
        int[] right = postOrder(root.right, distance);
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                if (i + j <= distance) {
                    result += left[i] * right[j];
                }
            }
        }
        int[] distances = new int[distance + 1];
        for (int i = 0; i < distances.length - 1; i++) {
            distances[i + 1] = left[i] + right[i];
        }
        return distances;
    }
}