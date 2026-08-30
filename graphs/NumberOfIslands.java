class Solution {
    /**
     * Pattern : Graphs - DFS/BFS on 2D grid, mark visited cells
     * Time : O(mxn) | Space : O(mxn)
     * 200. Number of Islands
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(grid, visited, i, j, m, n);
                    // bfs(grid, visited, i, j, m, n);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1' || visited[i][j]) return;

        visited[i][j] = true;
        dfs(grid, visited, i+1, j, m, n);
        dfs(grid, visited, i-1, j, m, n);
        dfs(grid, visited, i, j+1, m, n);
        dfs(grid, visited, i, j-1, m, n);
    }

    private void bfs(char[][] grid, boolean[][] visited, int startI, int startJ, int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        int[][] directions = {{-1,0}, {1, 0}, {0,-1}, {0,1}}; // up, down, left, right

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];

            for(int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    queue.offer(new int[]{newI, newJ});
                }
            }
        }
    }
}
