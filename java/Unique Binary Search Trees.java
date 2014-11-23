/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

dynamic programming 参照 LeetCode 题解     戴方勤 (soulmachine@gmail.com)     https://github.com/soulmachine/leetcode
*/
public class Solution {
    public int numTrees(int n) {
    	if(n<=1) return 1;
    	int f[] = new int[n+1];
    	f[0]=f[1]=1;
    	for(int i=2;i<=n;i++){
    		for(int k=0;k<i;k++){
    			f[i] += f[k]*f[i-k-1];
    		}
    	}
    	return f[n];
    }
}
