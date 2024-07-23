/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Map<Integer, Node> dp = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        if (dp.containsKey(node.val)) return dp.get(node.val);
        Node root = new Node(node.val);
        dp.put(root.val, root);
        for (Node neighbor: node.neighbors) {
            root.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }
}