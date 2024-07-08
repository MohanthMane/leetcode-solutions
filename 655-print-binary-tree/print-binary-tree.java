/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int rows = getHeight(root);
        int cols = (int) Math.pow(2, rows) - 1;
        String[][] result = new String[rows][cols];
        int startRow = 0, startCol = (cols - 1) / 2;
        dfs(result, startRow, startCol, root, rows, cols);

        List<List<String>> finalResult = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                String toAdd = result[i][j] == null ? "" : result[i][j];
                row.add(toAdd);
            }
            finalResult.add(row);
        }
        return finalResult;
    }

    private void dfs(String[][] result, int r, int c, TreeNode root, int totalRows, int totalCols) {
        if (root != null) {
            result[r][c] = String.valueOf(root.val);
            if (root.left != null) {
                int nextRow = r + 1, nextCol = c - (int) Math.pow(2, totalRows - r - 2);
                dfs(result, nextRow, nextCol, root.left, totalRows, totalCols);
            }
            if (root.right != null) {
                int nextRow = r + 1, nextCol = c + (int) Math.pow(2, totalRows - r - 2);
                dfs(result, nextRow, nextCol, root.right, totalRows, totalCols);
            }
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}