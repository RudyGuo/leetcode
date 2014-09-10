// There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
 
 public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int l=0,r=0;
        int m=0;
        
        if(A.length==0&&B.length==0){
            return (Double) null;
        }
        
        if(A.length==0){
            if(B.length%2==0){
                return ((double)(B[B.length/2])+(double)(B[B.length/2-1]))/2;
            }else{
                return (double)(B[B.length/2]);
            }
        }
        
        if(B.length==0){
            if(A.length%2==0){
                return ((double)(A[A.length/2])+(double)(A[A.length/2-1]))/2;
            }else{
                return (double)(A[A.length/2]);
            }
        }
        
        int []C=new int [A.length+B.length];
        
        while(l<A.length&&r<B.length){
            if(A[l]<B[r]){
                C[m]=A[l];
                ++l;
                ++m;
            }else{
                C[m]=B[r];
                ++r;
                ++m;
            }
            
            if(l==A.length){
                while(r<B.length){
                    C[m]=B[r];
                    ++m;
                    ++r;
                }
                break;
            }
            
            if(B.length==r){
                while(l<A.length){
                    C[m]=A[l];
                    ++m;
                    ++l;
                }
                break;
            }
        }
        
        if(m%2==0){
            return ((double)(C[m/2])+(double)(C[m/2-1]))/2;
        }else{
            return (double)(C[m/2]);
        }
        
    }
}