class Solution {

    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points) {
                    res = Math.max(res, 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - c[0] * b[1] - b[0] * a[1]));
                }
            }
        }
        return res;
    }
}