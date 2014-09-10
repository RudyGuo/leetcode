// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:

// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// 解题思路：两个相同的数异或为0，然后分为正负两种情况考虑，就得到线性的解法。

public class Solution {  
    public int singleNumber(int[] A) {  
        int zres=0;  
        int fres=0;  
        for(int i=0;i<A.length;i++){  
            if(A[i]>=0){  
               zres ^=A[i];   
            }else{  
               fres ^=-A[i];  
            }  
              
        }  
        if(0==zres&&0==fres){  
            return 0;  
        }else if(zres!=0){  
            return zres;  
        }else{  
            return -fres;  
        }  
    }  
} 