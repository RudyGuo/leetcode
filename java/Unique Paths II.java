/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.*/

public class Solution {
	int [][]g;
	int [][]f;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        f = new int[row][column];
        g = obstacleGrid;
        return uniquePaths(row-1,column-1);
    }
    
    private int uniquePaths(int m,int n){
        if(m<0||n<0||g[0][0]==1) return 0;
    	if(m==0&&n==0&&g[0][0]==0) return 1;
    	if(g[m][n]==0){
    		return help(m-1,n)+help(m,n-1);
    	}else{
    		return 0;
    	}
    }
    
    private int help(int m,int n){
        if(m<0||n<0||g[0][0]==1) return 0;
    	if(f[m][n]>0) return f[m][n];
    	return f[m][n] = uniquePaths(m,n); 
    }
}



