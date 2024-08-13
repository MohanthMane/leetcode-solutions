class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        return constructBalancedBST(inorder);
    }

    private TreeNode constructBalancedBST(List<Integer> inorder) {
        int l = 0, r = inorder.size() - 1;
        if (l > r) return null;
        if (l == r) return new TreeNode(inorder.get(l));

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = constructBalancedBST(inorder.subList(l, mid));
        root.right = constructBalancedBST(inorder.subList(mid + 1, r + 1));
        return root;
    }

    private void dfs(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
    }
}
