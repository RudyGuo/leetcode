/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
*/

public class Solution {
	int[][] f;
	class Node{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		int x,y;
		Node(int x,int y){
			this.x = x;
			this.y = y;
		}
		private Solution getOuterType() {
			return Solution.this;
		}
	}
	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int column = dungeon[0].length;
		f = new int[row][column];
		Set<Node> used = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> rep = new LinkedList<>();
		queue.offer(new Node(row-1,column-1));
		f[row-1][column-1] = (dungeon[row-1][column-1]>0?1:-dungeon[row-1][column-1]+1);
		while(!queue.isEmpty()){
			while(!queue.isEmpty()){
				Node node = queue.poll();
				int x = node.x,y = node.y;
				if(x-1>=0) {
					Node node1 = new Node(x-1,y);
					if(!used.contains(node1)){
						rep.offer(node1);
						used.add(node1);
					}
				}
				if(y-1>=0) {
					Node node1 = new Node(x,y-1);
					if(!used.contains(node1)){
						rep.offer(node1);
						used.add(node1);
					}
				}
				if(x==row-1&&y==column-1) continue;
				Integer left = null, up =null;
				if(x+1<row){
					up = Math.max(1, -dungeon[x][y]+f[x+1][y]);
				}
				if(y+1<column){
					left = Math.max(1, -dungeon[x][y]+f[x][y+1]);
				}
				if(left!=null&&up!=null){
					f[x][y] = Math.min(left, up);
				}else if(left!=null){
					f[x][y] = left;
				}else if(up!=null){
					f[x][y] = up;
				}
			}
			Queue<Node> lin = queue;
			queue = rep;
			rep = lin;
		}
		return f[0][0];
	}
}
