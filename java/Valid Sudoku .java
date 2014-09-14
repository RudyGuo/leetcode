/* Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
        	char[]column=new char[9];
        	for(int j = 0;j<9;j++){
        		column[j]=board[j][i];
        	}
        	if(!isRow(board[i])||!isRow(column))return false;
        }
        for(int i=0;i<9;i+=3){
        	for(int j=0;j<9;j+=3){
        		if(!isBox(board,i,j)) return false;
        	}
        }
        return true;
    }
    
    private boolean isRow(char[] board){
    	Set<Character> set = new HashSet<>();
    	for(int i = 0;i<board.length;i++){
    		if(board[i]=='.') continue;
    		if(set.contains(board[i])) return false;
    		set.add(board[i]);
    	}
    	return true;
    }
    
    private boolean isBox(char[][] board,int row ,int column){
    	Set<Character> set = new HashSet<>();
    	for(int i = row;i<row+3;i++){
    		for(int j = column;j<column+3;j++){
				if (board[i][j] == '.')
					continue;
				if (set.contains(board[i][j]))
					return false;
				set.add(board[i][j]);
    		}
    	}
    	return true;
    }
}