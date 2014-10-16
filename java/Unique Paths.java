/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


参考：戴方勤 (soulmachine@gmail.com)     https://github.com/soulmachine/leetcode

深搜（递归）  +   备忘录
*/
public class Solution {  
    private int f[][];  
    public int uniquePaths(int m, int n) {  
        f = new int[m+1][n+1];  
        return dfs(m,n);  
    }  
      
    private int dfs(int m,int n){  
        if(m<1||n<1) return 0;  
        if(m==1&&n==1) return 1;  
        return help(m-1,n)+help(m,n-1);  
    }  
  
    private int help(int m,int n){  
        if(f[m][n]>0)return f[m][n];  
        return f[m][n]=dfs(m,n);  
    }  
}  