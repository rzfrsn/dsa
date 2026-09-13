class Solution {
    /**
     * Pattern : Graphs - Union Find, count distinct root groups
     * Time : O(E) | Space : O(E)
     * 323. Number of Connected Components in an Undirected Graph
     */
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        for(var e : edges) {
            union(parent, e[0], e[1]);
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) result++;
        }

        return result;
    }

    private int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if(rootX == rootY) return;

        parent[rootX] = rootY;
    }
}
