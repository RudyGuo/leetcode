/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
*/
public class Solution {
    public int rob(int[] num) {
       if(num==null||num.length==0) return 0;
       int include = 0;
       int exclude = 0;
       for(int i=0;i<num.length;i++){
        int tmp = include;
        include = exclude+num[i];
        exclude = Math.max(tmp, exclude);
       }
       return Math.max(include, exclude);
    }
}

