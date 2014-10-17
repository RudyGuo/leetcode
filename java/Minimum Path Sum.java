/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/


public class Solution {
	private int f[][];
	private int g[][];
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
    	f = new int[m+1][n+1];
    	g= grid;
    	return dfs(m,n);
    }
    
    private int dfs(int m,int n){
    	if(m<1||n<1) return 2000000000;
    	if(m==1&&n==1) return g[0][0];
    	return Math.min(help(m-1,n),help(m,n-1))+g[m-1][n-1];
    }
    
    private int help(int m,int n){
    	if(f[m][n]>0) return f[m][n];
    	return f[m][n] = dfs(m,n);
    }
}


