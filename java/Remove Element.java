/* Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. */

public class Solution {
    public int removeElement(int[] A, int elem) {
    	int left = 0;
    	int right = A.length-1;
        while(left<=right){
        	if(A[left] == elem){
        		A[left] = A[left]^A[right];
        		A[right] = A[left]^A[right];
        		A[left] = A[left]^A[right];
        		right--;
        	}else{
        		left++;
        	}
        }
        return ++right;
    }
}