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
    public void flatten(TreeNode root) {
        root = solve(root);
    }

    private TreeNode solve(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        // These are leaf nodes of flattened sub tree. So we can't stitch directly
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right == null ? left : right;
    }
}