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
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        // Map to store the original node as key and the cloned node as value
        Map<Node, Node> visited = new HashMap<>();
        
        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        // Create a clone of the starting node
        visited.put(node, new Node(node.val));
        
        // Traverse the graph using BFS
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Create a clone of the neighbor node and put it in the map
                    visited.put(neighbor, new Node(neighbor.val));
                    // Add the clone of the neighbor to the clone of the current node's neighbors list
                    visited.get(curr).neighbors.add(visited.get(neighbor));
                    // Add the neighbor to the queue for further exploration
                    queue.add(neighbor);
                } else {
                    // If the neighbor is already visited, add its clone to the clone of the current node's neighbors list
                    visited.get(curr).neighbors.add(visited.get(neighbor));
                }
            }
        }
        
        // Return the clone of the starting node
        return visited.get(node);
    }
}