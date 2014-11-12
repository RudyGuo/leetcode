/*Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m andn respectively.
*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i=0,j=0,sum=0;
        while(i<m+sum&&j<n){
        	if(A[i]<=B[j]){
        		i++;
        	}else{
        		for(int k=sum+m;k>i;k--){
        			A[k] = A[k-1];
        		}
        		A[i] = B[j];
        		j++;
        		i++;
        		sum++;
        	}
        }
        for(int t=j;t<n;t++){
        	A[i++] = B[t];
        }
    }
}
