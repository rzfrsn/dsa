class Solution {
    private static final int[][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    private int m = 0;
    private int n = 0;

    /**
     * Pattern : Graphs - DFS, explore from border
     * Time : O(m×n) | Space : O(m×n)
     * 130. Surrounded Regions
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] out = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            dfs(board, out, i, 0);
            dfs(board, out, i, n - 1);
        }

        for(int j = 0; j < n; j++) {
            dfs(board, out, 0, j);
            dfs(board, out, m - 1, j);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !out[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, boolean[][] out, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || out[i][j]) return;
        if(board[i][j] == 'X') return;

        out[i][j] = true;

        for(int[] dir : directions) {
            var newI = i + dir[0];
            var newJ = j + dir[1];

            dfs(board, out, newI, newJ);
        }
    }
}
