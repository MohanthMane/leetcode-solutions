/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return result;
    }

    private void dfs(Node root) {
        if (root != null) {
            for (Node child: root.children) {
                dfs(child);
            }
            result.add(root.val);
        }
    } 
}