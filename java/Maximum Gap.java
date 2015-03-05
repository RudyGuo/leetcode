/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.

桶排序
*/
public class Solution {
	class Pair{
		int min;
		int max;
		Pair(int min,int max){
			this.min = min;
			this.max = max;
		}
	}
    public int maximumGap(int[] num) {
    	if(num.length<=1) return 0;
    	int mn = num[0],mx = num[0];
    	int len = num.length;
    	for(int n:num){
    		mn = Math.min(mn, n);
    		mx = Math.max(mx, n);
    	}
    	if(mn== mx) return 0;
    	//桶间的间隔
    	int dist = (mx-mn)/len+1;
    	//每个pair就是一个桶，用来存储映射到该桶的最大与最小数
    	Pair[]buck = new Pair[len];
    	for(int n:num){
    		//映射的桶下标
    		int index = (n-mn)/dist;
    		if(buck[index]==null) {
    			buck[index]= new Pair(n,n);
    			continue;
    		}
    		Pair p = buck[index];
    		p.min = Math.min(n,p.min);
    		p.max = Math.max(n,p.max);
    	}
    	int preMax = buck[0].max;
    	int res = preMax-buck[0].min;
    	for(int i=1;i<buck.length;i++){
    		Pair p = buck[i];
    		if(p==null) continue;
    		res = Math.max(p.min-preMax, res);
    		preMax = p.max;
    	}
    	return res;
    }
}