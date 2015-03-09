/* A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

二分法轻松解决
*/
public class Solution {  
    public int findPeakElement(int[] num) {  
        if (num.length == 1)return 0;  
        if (num[0] > num[1])return 0;  
        if (num[num.length - 1] > num[num.length - 2])return num.length - 1;  
        int i = 0, j = num.length - 1;  
        while (i <= j) {  
            int mid = (i + j) / 2;  
            if(mid==0) mid++;  
            if(mid==num.length-1) mid--;  
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {  
                return mid;  
            } else if (num[mid] < num[mid + 1]) {  
                i = mid + 1;  
            } else {  
                j = mid - 1;  
            }  
        }  
        throw new IllegalArgumentException();  
    }  
}  
