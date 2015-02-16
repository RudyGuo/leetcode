/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

这道题利用深搜会StackOverFlow，思想是所有在最边的'O'及其相连的区域都不会覆盖，找出所有这样的区域，记录在isChecked数组中，遍历修改，其中有一句很重的判重，搞了2个小时才找到。
*/
public class Solution {
	boolean isChecked[][];
	int seq = 0;
    public void solve(char[][] board) {
    	if(board.length==0) return;
    	if(board.length<=2||board[0].length<=2) return;
    	int row = board.length, column = board[0].length;
    	isChecked = new boolean[row][column];
    	//下面的连个循环用来搜索靠边，且为'O'的部分，然后利用宽搜搜索所有区域
    	for(int i=0;i<row;i++){
    		if(!isChecked[i][0]&&board[i][0]=='O') 
    			bfs(board,i,0);
    		if(!isChecked[i][column-1]&&board[i][column-1]=='O') 
    			bfs(board,i,column-1);
    	}
    	for(int j=1;j<column-1;j++){
    		if(!isChecked[0][j]&&board[0][j]=='O') 
    			bfs(board,0,j);
    		if(!isChecked[row-1][j]&&board[row-1][j]=='O') 
    			bfs(board,row-1,j);
    	}
    	//遍历，找到要被修改为'X'的'O'
    	for(int i=1;i<row-1;i++){
    		for(int j=1;j<column-1;j++){
    			if(board[i][j]=='O'&&!isChecked[i][j]) board[i][j] = 'X';
    		}
    	}
    }
    private void bfs(char[][] board,int xd,int yd){
    	int row = board.length, column = board[0].length;
    	Queue<int[]> current = new LinkedList<>();
    	current.offer(new int[]{xd,yd});
    	//不记录广搜分层
    	while(!current.isEmpty()){
			int[] cd = current.poll();
			int x=cd[0], y = cd[1];
			isChecked[x][y] = true;
			seq++;
			int move[][] ={{x-1,y},{x,y+1},{x+1,y},{x,y-1}};
			for(int i=0;i<4;i++){
				int dx = move[i][0], dy = move[i][1];
				if(dx<0||dx>=row||dy<0||dy>=column||isChecked[dx][dy]||board[dx][dy]!='O') continue;
				//下面一句话巨重要，当找到'O'的时候就要记录它已经被搜索过，如果没有记录则其他的路径也会搜索到该点
				isChecked[dx][dy] = true;
				current.add(new int[]{dx,dy});
			}
    	}
    	System.out.println(seq);
    }
}

