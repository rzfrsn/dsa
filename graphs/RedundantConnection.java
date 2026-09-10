class Solution {
    /**
     * Pattern : Graphs - Union Find, detect cycle via same-group check
     * Time : O(E) | Space : O(E)
     * 684. Redundant Connection
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(var e : edges) {
            if(!union(parent, e[0], e[1])) return e;
        }

        return new int[]{};
    }

    private int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if(rootX == rootY) return false;

        parent[rootX] = rootY;
        return true;
    }

}
