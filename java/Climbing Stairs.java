/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

深搜+备忘录*/
public class Solution {
	int f[];
	public int climbStairs(int n) {
		f = new int[n+1];
		return climb(n);
	}
	
	private int climb(int n){
		if(n<=0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		return store(n-1)+store(n-2);
	}
	
	private int store(int n){
		if(n<=0) return 0;
		if(f[n]>0) return f[n];
		return f[n] = climb(n);
	}
}
