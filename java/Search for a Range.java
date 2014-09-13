/* Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4] */

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int res[]={-1,-1};
        int index = Arrays.binarySearch(A, target);
        if(index<0) return res;
        int left = index,right =index;
        while(left>=0&&A[left]==target)left--;
        while(right<A.length&&A[right]==target)right++;;
        res[0]=left+1;
        res[1]=right-1;
        return res; 
    }
}