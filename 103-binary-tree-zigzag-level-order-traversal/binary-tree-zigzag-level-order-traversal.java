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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean reverse = true;
        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> level = new ArrayDeque<>(); 
            while (size > 0) {
                TreeNode curr = q.poll();
                if (reverse) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                size--;
            }
            result.add(new ArrayList<>(level));
            reverse = !reverse;
        }
        return result;
    }
}