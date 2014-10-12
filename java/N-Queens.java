/*The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/


public class Solution {
	boolean[] column = null;
	boolean[] diag = null;
	boolean[] anti_diag = null;
	int[]C = null;
	String model = null;
    public List<String[]> solveNQueens(int n) {
        column = new boolean[n];
        diag = new boolean[2*n];
        anti_diag = new boolean[2*n];
        C = new int[n];//Q在第i行的第几列
        List<String []> res = new ArrayList<>();

        dfs(0,res,n);
        return res;
        
    }
    
    private void dfs(int row,List<String[]> res,int n){
    	if(row==n){
    		String [] str = new String[n];
    		for(int i=0;i<n;i++){
    			StringBuilder sb = new StringBuilder();
    			for(int j=0;j<n;j++){
    				if(C[i]==j){
    					sb.append("Q");
    				}else{
    					sb.append(".");
    				}
    			}
    			str[i] = sb.toString();
    		}
    		res.add(str);
    		return;
    	}
    	
    	for(int j=0;j<n;j++){
    		if(!column[j]&&!anti_diag[row+j]&&!diag[n-row-1+j]){
    			C[row]=j;
    		}else{
    			continue;
    		}
    		column[j]=anti_diag[row+j]=diag[n-row-1+j]=true;
    		dfs(row+1,res,n);
    		column[j]=anti_diag[row+j]=diag[n-row-1+j]=false;
    	}
    }
}