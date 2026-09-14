/**
 * Pattern : Graphs - Multi-source BFS on 2D grid
 * Time : O(m x n) | Space : O(m x n)
 * 286. Walls and Gates (Islands an Treasure)
 */
class Solution {
    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int islandsCount = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) queue.offer(new int[]{i, j});
                if(grid[i][j] > 0 ) islandsCount++;
            }
        }

        if(islandsCount == 0) return;

        int distance = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()) {
            int size = queue.size();

            distance++;
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for(var d : directions) {
                    int newI = curr[0] + d[0];
                    int newJ = curr[1] + d[1];

                    if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == INF) {
                        grid[newI][newJ] = distance;
                        queue.offer(new int[]{newI, newJ});
                    }
                }
            }
        }

    }
}
