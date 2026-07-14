/**
 * Pattern : Square Matrix — Set per row, col, box
 * Time : O(1) always 9x9 | Space : O(1)
 * LeetCode 36 - Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>(board.length);
        Set<String> col = new HashSet<>(board.length);
        Map<String, Set<String>> map = new HashMap<>(board.length);

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                String cr = String.valueOf(board[i][j]);
                String cc = String.valueOf(board[j][i]);

                int boxIndex = (i / 3) * 3 + (j / 3);
                String boxKey = String.valueOf(boxIndex);
                Set<String> box = map.computeIfAbsent(boxKey, k -> new HashSet<>());

                if(!cr.equals(".")) {
                    if(row.contains(cr)) return false;
                    if(box.contains(cr)) return false;
                    box.add(cr);
                    row.add(cr);
                }

                if(!cc.equals(".")) {
                    if(col.contains(cc)) return false;
                    col.add(cc);
                }
            }
            row.clear();
            col.clear();
        }

        return true;
    }
}
