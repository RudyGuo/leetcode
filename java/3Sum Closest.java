Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {  
    public int threeSumClosest(int[] num, int target) {  
         if(num == null||num.length<3){  
            System.exit(0);  
         }  
         Arrays.sort(num);  
         int res =0;  
         int mini = 2000000000;   
        for(int i=0;i<num.length-2;i++){  
             
           int ta = target - num[i];  
           int left = i+1;  
           int right = num.length - 1;  
             
           while(left<right){  
               if(ta == num[left]+num[right]){  
                    return target;  
               }else if(ta > num[left]+num[right]){  
                   if(mini>ta-num[left]-num[right]){  
                       res = num[left]+num[right]+num[i];  
                       mini = ta-num[left]-num[right];  
                   }  
                   left++;  
               }else{  
                   if(mini>num[left]+num[right]-ta){  
                       res = num[left]+num[right]+num[i];  
                       mini = num[left]+num[right]-ta;  
                   }  
                   right--;  
               }  
           }  
        }  
        return res;  
    }  
} 