/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?


分别从前往后，再从后往前 遍历，关键是max中的表达式
*/
public class Solution {  
    public int candy(int[] ratings) {  
        int len = ratings.length;  
        int res[] = new int[len];  
        int ret = 0;  
        for(int i=1,inc =1;i<len;i++){  
            if(ratings[i-1]<ratings[i]) {  
                res[i] = Math.max(res[i], inc++);  
            }else{  
                inc = 1;  
            }  
        }  
        for(int i=len-2,inc =1;i>=0;i--){  
            if(ratings[i]>ratings[i+1]){  
                res[i] = Math.max(res[i], inc++);  
            }else{  
                inc = 1;  
            }  
        }  
        for(int i:res){  
            ret += i;  
        }  
        return ret+len;  
    }  
}  