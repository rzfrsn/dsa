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
    /**
     * Pattern : Graphs - DFS, HashMap mapping original to copy (handles cycles)
     * Time : O(n) | Space : O(n)
     * 133. Clone Graph
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfsCopy(node, map);
    }

    private Node dfsCopy(Node node, Map<Node,Node> map) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);

        var copy = new Node(node.val);
        map.put(node, copy);

        for(var n : node.neighbors) {
            copy.neighbors.add(dfsCopy(n, map));
        }

        return copy;
    }
}
