// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].
 
public class Solution {
    public int removeDuplicates(int[] A) {
    	final int max = (int) Math.pow(2, 31);
    	int length = A.length;
    	int i = 0,comp = max,res = 0;
    	while(i<length){
    		if(A[i]!=comp){
    			comp = A[i];
    			res ++;
    		}else{
    			A[i] = max;
    		}
    		i++;
    	}
    	Arrays.sort(A);
    	return res;
    }
    int removeDuplicates2(int A[]) {
    	int n = A.length;
        if(n < 2) return n;
        int id = 1;
        for(int i = 1; i < n; ++i) 
            if(A[i] != A[i-1]) A[id++] = A[i];
        return id;
    }
}