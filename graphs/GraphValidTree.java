class Solution {
    /**
     * Pattern : Graphs - Union Find, check edge count + no cycle
     * Time : O(E) | Space : O(E)
     * 261 - Graph Valid Tree
     */
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        for(var e : edges) {
            if(!union(parent, e[0], e[1])) return false;
        }

        return true;
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
