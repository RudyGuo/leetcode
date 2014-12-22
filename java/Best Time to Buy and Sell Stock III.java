/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

用left[ i ]和right[ j ]分别表示第一次与第二卖出的收入，其中left[ i ]表示i个元素之前买入卖出股票所能赚的最多的钱，right[ i ]表示i个元素之后买入卖出股票所能赚的最多的钱，
下面为具体的实现 ps:可以同一天买入卖出
*/
 
public class Solution {  
    public int maxProfit(int[] prices) {  
        if(prices.length<2) return 0;  
        int []left =new int[prices.length];  
        int []right = new int[prices.length];  
        int minVal = prices[0];  
        for(int i=1;i<prices.length;i++){  
            minVal = Math.min(minVal, prices[i]);  
            left[i] = Math.max(left[i-1], prices[i]-minVal);  
        }  
        int maxVal = prices[prices.length-1];  
        for(int i=prices.length-2;i>=0;i--){  
            maxVal = Math.max(maxVal, prices[i]);  
            right[i] = Math.max(right[i+1], maxVal -prices[i]);  
        }  
        int res =  left[0]+right[0];  
        for(int i=1;i<prices.length;i++){  
            res = Math.max(res, left[i]+right[i]);  
        }  
        return res;  
    }  
}  