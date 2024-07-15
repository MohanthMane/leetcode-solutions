class Solution {

    private static int[] dx = {0, 1, -1, 0};
    private static int[] dy = {1, 0, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]) return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int srcColor) {
        if (r < 0 || c < 0 || r == image.length || c == image[r].length || image[r][c] != srcColor) {
            return;
        }

        image[r][c] = color;
        for (int i = 0; i < 4; i++) {
            dfs(image, r + dx[i], c + dy[i], color, srcColor);
        }
    }
}