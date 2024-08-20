class LRUCache {

    public static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node next, Node prev) { 
            this.key = key;
            this.val = val;
            this.next = next; 
            this.prev = prev;
        }

        public Node(int key, int val) { 
            this.key = key;
            this.val = val;
            this.next = null; 
            this.prev = null;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> nodeMap;
    private final Node first = new Node(-1, -1);
    private final Node last = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        first.next = last;
        last.prev = first;
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node current = nodeMap.get(key);
            updateMru(current);
            return current.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            nodeMap.get(key).val = value;
            updateMru(nodeMap.get(key));
        } else {
            Node newNode = new Node(key, value);
            if (nodeMap.size() == capacity) {
                Node lruNode = first.next;
                nodeMap.remove(lruNode.key);
                popLru();
            }
            addEndNode(newNode);
            nodeMap.put(key, newNode);
        }
    }
    
    private void deleteNode(Node toDelete) {
        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
    }

    private void popLru() {
        this.deleteNode(first.next);
    }

    private void updateMru(Node mruNode) {
        this.deleteNode(mruNode);
        this.addEndNode(mruNode);
    }

    private void addEndNode(Node node) {
        Node currentEndNode = last.prev;
        currentEndNode.next = node;
        last.prev = node;
        node.prev = currentEndNode;
        node.next = last;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */