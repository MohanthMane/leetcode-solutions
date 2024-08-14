class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for (int[] description: descriptions) {
            int parent = description[0], child = description[1];
            int direction = description[2];

            degreeMap.putIfAbsent(parent, 0);
            degreeMap.putIfAbsent(child, 0);
            degreeMap.put(child, degreeMap.get(child) + 1);

            if (!nodeMap.containsKey(parent)) {
                nodeMap.put(parent, new TreeNode(parent));
            }
            if (!nodeMap.containsKey(child)) {
                nodeMap.put(child, new TreeNode(child));
            }
            TreeNode parentNode = nodeMap.get(parent);
            TreeNode childNode = nodeMap.get(child);
            
            if (direction == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }
        
        for (int node: degreeMap.keySet()) {
            if (degreeMap.get(node) == 0) {
                return nodeMap.get(node);
            }
        }
        return null;
    }
}