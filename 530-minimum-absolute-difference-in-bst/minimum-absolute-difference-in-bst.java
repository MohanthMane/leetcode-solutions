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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < inorder.size(); i++) {
            result = Math.min(result, inorder.get(i) - inorder.get(i - 1));
        }
        return result;
    }

    private void dfs(TreeNode root, List<Integer> inorder) {
        if (root != null) {
            dfs(root.left, inorder);
            inorder.add(root.val);
            dfs(root.right, inorder);
        }
    }
}