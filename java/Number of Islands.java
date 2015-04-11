
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3



bfs 主义层之间的互相访问要遏制。
public class Solution {
	
	class Pair{
		int x,y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
    public int numIslands(char[][] grid) {
    	if(grid==null||grid.length==0) return 0;
    	int row = grid.length,column = grid[0].length;
    	int res = 0;
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		if(grid[i][j]=='1'){
        			bfs(grid, i, j);
        			res++;
        		}
        	}
        }
        return res;
    }
    
    private void bfs(char[][]grid,int i,int j){
    	Queue<Pair> que = new LinkedList<>();
    	que.offer(new Pair(i,j));
    	while(!que.isEmpty()){
    		Pair p= que.poll();
    		grid[p.x][p.y] = '*';
    		if(isIsland(grid, p.x-1, p.y)){
    			//非常重要，防止同层之间互相加
    			grid[p.x-1][p.y] ='*';
    			que.offer(new Pair(p.x-1,p.y));
    		}
    		if(isIsland(grid, p.x+1, p.y)){
    			grid[p.x+1][p.y] ='*';
    			que.offer(new Pair(p.x+1,p.y));
    		}
    		if(isIsland(grid, p.x, p.y-1)){
    			grid[p.x][p.y-1] ='*';
    			que.offer(new Pair(p.x,p.y-1));
    		}
    		if(isIsland(grid, p.x, p.y+1)){
    			grid[p.x][p.y+1] ='*';
    			que.offer(new Pair(p.x,p.y+1));
    		}
    	}
    }
    
    private boolean isIsland(char[][]grid,int i,int j){
    	if(i<0||i>=grid.length||j<0||j>=grid[0].length) return false;
    	if(grid[i][j]=='1') return true;
    	return false;
    }
}
dfs代码较简单，但运行时间比bfs慢

public class Solution {
	
    public int numIslands(char[][] grid) {
    	if(grid==null||grid.length==0) return 0;
    	int row = grid.length,column = grid[0].length;
    	int res = 0;
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		if(grid[i][j]=='1'){
        			dfs(grid, i, j);
        			res++;
        		}
        	}
        }
        return res;
    }
    
    private void dfs(char[][]grid,int i,int j){
    	grid[i][j] = '*';
    	if(isIsland(grid, i-1, j)) dfs(grid,i-1,j);
    	if(isIsland(grid, i+1, j)) dfs(grid,i+1,j);
    	if(isIsland(grid, i, j-1)) dfs(grid,i,j-1);
    	if(isIsland(grid, i, j+1)) dfs(grid,i,j+1);
    }
    
    private boolean isIsland(char[][]grid,int i,int j){
    	if(i<0||i>=grid.length||j<0||j>=grid[0].length) return false;
    	if(grid[i][j]=='1') return true;
    	return false;
    }
}


