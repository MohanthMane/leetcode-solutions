class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        return "U".repeat(pathToStart.length()) + pathToDest;
    }

    private boolean findPath(TreeNode node, int targetValue, StringBuilder path) {
        if (node == null) return false;
        if (node.val == targetValue) return true;

        path.append("L");
        if (findPath(node.left, targetValue, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        if (findPath(node.right, targetValue, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    private TreeNode findLCA(TreeNode node, int a, int b) {
        if (node == null) return null;
        if (node.val == a || node.val == b) return node;

        TreeNode left = findLCA(node.left, a, b);
        TreeNode right = findLCA(node.right, a, b);

        if (left == null) return right;
        else if (right == null) return left;
        else return node;
    }
}