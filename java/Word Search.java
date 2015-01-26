/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {  
    boolean status[][];  
    int move[][] = { { -1, 0, 1, 0 }, { 0, -1, 0, 1 } };  
    public boolean exist(char[][] board, String word) {  
        status = new boolean[board.length][board[0].length];  
        for (int i = 0; i < board.length; i++) {  
            for (int j = 0; j < board[0].length; j++) {  
                if (board[i][j] == word.charAt(0)) {  
                    if(dfs(board, word, i, j, 0)) return true;  
                }  
            }  
        }  
        return false;  
    }  
  
    private boolean dfs(char[][] board, String word, int x, int y, int index) {  
        if (index >= word.length()) {  
            return true;  
        }  
        //【剪枝】超出边界，字符不匹配，已经被搜查过  
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length||word.charAt(index) != board[x][y]||status[x][y]) return false;  
        status[x][y] = true;  
        for (int k = 0; k <= 3; k++) {  
            int nx = x + move[0][k];  
            int ny = y + move[1][k];  
                if(dfs(board, word, nx, ny, index + 1)) return true;  
        }  
        //回溯  
        status[x][y] = false;  
        return false;  
    }  
}    