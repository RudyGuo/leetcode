/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
用一个数组记录每一位中1个的个数，如果不是3的倍数，则说明是那个single one
*/
public class Solution {
    public int singleNumber(int[] A) {
        int bit[] = new int[32];
        int res = 0;
        for(int i=0;i<A.length;i++){
        	for(int j=0;j<32;j++){
        		if(((A[i]>>j)&1)==1) bit[j]++;
        	}
        }
        for(int i=31;i>=0;i--){
        	int bitNum = bit[i]%3;
        	if(bitNum%3!=0){
        		res +=bitNum<<i;
        	}
        }
        return res;
    }
}
