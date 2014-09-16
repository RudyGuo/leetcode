/* Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red. */


public class Solution {
	public void solveSudoku(char[][] board) {
		solve(board);
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k < 10; k++) {
						board[i][j] = (char) (k + '0');
						if (help(board, i, j, (char) (k + '0'))&&solve(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean help(char[][] board, int row, int column, char c) {
		int x = row / 3, y = column / 3;
		for (int i = x*3; i < x*3 + 3; i++) {
			for (int j = y*3; j < y*3 + 3; j++) {
				if (i != row && j != column && board[i][j] == c) {
					return false;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != row && board[i][column] == c) {
				return false;
			}

		}
		for (int i = 0; i < 9; i++) {
			if (i != column && board[row][i] == c) {
				return false;
			}

		}
		return true;
	}
}