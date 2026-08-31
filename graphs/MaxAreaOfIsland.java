class Solution {
    /**
     * Pattern : Graphs - DFS/BFS on 2D grid, sum connected cells (island area)
     * Time : O(mxn) | Space : O(mxn)
     * 695. Max Area of Island
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsAreaCnt(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfsAreaCnt(int[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != 1) return 0;

        grid[i][j] = 0;

        int up = dfsAreaCnt(grid, i+1, j);
        int down = dfsAreaCnt(grid, i-1, j);
        int left = dfsAreaCnt(grid, i, j-1);
        int right = dfsAreaCnt(grid, i, j+1);

        return 1 + up + down + left + right;
    }
}
