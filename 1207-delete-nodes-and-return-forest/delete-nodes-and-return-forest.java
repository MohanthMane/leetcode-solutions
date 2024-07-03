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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int node: to_delete) {
            toDelete.add(node);
        }
        List<TreeNode> result = new ArrayList<>();
        dfs(root, result, toDelete);
        if (!toDelete.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> result, Set<Integer> toDelete) {
        if (root != null) {
            root.left = dfs(root.left, result, toDelete);
            root.right = dfs(root.right, result, toDelete);

            if (toDelete.contains(root.val)) {
                if (root.left != null) result.add(root.left);
                if (root.right != null) result.add(root.right);
                return null;
            }
            return root;
        }
        return null;
    }
}