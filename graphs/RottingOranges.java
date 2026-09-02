class Solution {
    /**
     * Pattern : Graphs - Multi-source BFS on 2D grid
     * Time : O(m x n) | Space : O(m x n)
     * 994. Rotting Oranges
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                if(grid[i][j] == 1) freshCount++;
            }
        }

        if(freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for(int i=0; i < size; i++) {
                int[] curr = queue.poll();

                for(var d : directions) {
                    int newI = curr[0] + d[0];
                    int newJ = curr[1] + d[1];

                    if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2;
                        freshCount--;
                        queue.offer(new int[]{newI, newJ});
                    }
                }
            }
            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}
