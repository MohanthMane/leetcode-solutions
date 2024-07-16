class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length, n = image[0].length;
        int[][] result = new int[m][n];

        int i = 0;
        for (int[] row: image) {
            int k = 0;
            for (int j = row.length - 1; j>=0; j--) {
                result[i][k++] = (image[i][j] == 0) ? 1 : 0;
            }
            i++;
        }

        return result;
    }
}