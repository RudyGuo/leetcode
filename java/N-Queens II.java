/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
	boolean[] column = null;
	boolean[] diag = null;
	boolean[] anti_diag = null;
	int[]C = null;
	int res = 0;
    public int totalNQueens(int n) {
        column = new boolean[n];
        diag = new boolean[2*n];
        anti_diag = new boolean[2*n];
        C = new int[n];//Q在第i行的第几列
        dfs(0,n);
        return res;
        
    }
    
    private void dfs(int row,int n){
    	if(row==n){
    		res++;
    		return;
    	}
    	for(int j=0;j<n;j++){
    		if(!column[j]&&!anti_diag[row+j]&&!diag[n-row-1+j]){
    			C[row]=j;
    		}else{
    			continue;
    		}
    		column[j]=anti_diag[row+j]=diag[n-row-1+j]=true;
    		dfs(row+1,n);
    		column[j]=anti_diag[row+j]=diag[n-row-1+j]=false;
    	}
    }

}