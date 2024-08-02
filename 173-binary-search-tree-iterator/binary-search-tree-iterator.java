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
class BSTIterator {

    private TreeNode current;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.current = root;
        this.stack = new Stack<>();
        while (this.current != null) {
            stack.push(this.current);
            this.current = this.current.left;
        }
    }
    
    public int next() {
        int result = stack.peek().val;
        TreeNode trav = stack.pop();
        if (trav.right != null) {
            trav = trav.right;
            while (trav != null) {
                stack.push(trav);
                trav = trav.left;
            }
        }
        return result;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */