/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

动态规划
*/
public class Solution {
	int []f;
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
        f = new int[(size+1)*(size)/2];
        f[0] = triangle.get(0).get(0);
        for(int i=1;i<size;i++){
        	for(int j=0;j<triangle.get(i).size();j++){
        		int left = i*(i-1)/2+j-1;
        		int right = i*(i-1)/2+j;
        		int cur = i*(i+1)/2+j;
        		int val = triangle.get(i).get(j);
        		if(j==0){
        			f[cur] = f[right]+val; 
        		}else if(j==triangle.get(i).size()-1){
        			f[cur] = f[left]+val;
        		}else{
        			f[cur] = Math.min(f[left], f[right]) + val;
        		}
        	}
        }
        int res = f[size*(size-1)/2];
        for(int j=size*(size-1)/2+1;j<f.length;j++){
        	res = Math.min(f[j], res);
        }
        return res;
    }
}

深搜（超时）
public class Solution {
	int minRes = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        minimumTotal(triangle,0,0,0);
        return minRes;
    }
    
    private void minimumTotal(List<List<Integer>> triangle,int sum,int size,int column){
    	if(size==triangle.size()){
    		minRes = Math.min(sum, minRes);
    		return;
    	}
    	sum += triangle.get(size).get(column);
    	minimumTotal(triangle,sum,size+1,column);
    	minimumTotal(triangle,sum,size+1,column+1);
    }
}


