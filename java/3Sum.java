// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
    // For example, given array S = {-1 0 1 2 -1 -4},

    // A solution set is:
    // (-1, 0, 1)
    // (-1, -1, 2)
// 以一个数为target然后循环求得是否有两个数等于之，while循环里是关键算法。

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null||num.length<3){
        	return res;
        }
        Arrays.sort(num);
       for(int i=0;i<num.length-2;i++){
    	   int target = -num[i];
    	   int left = i+1;
    	   int right = num.length - 1;
    	   while(left<right){
    		   if(target == num[left]+num[right]){
    			   List<Integer> lists= new ArrayList<Integer>();
    			   lists.add(num[i]);
    			   lists.add(num[left]);
    			   lists.add(num[right]);
    			   if(res.isEmpty()||!res.contains(lists)){
    				  res.add(lists);
    			   }
    			   left++;
    			   right--;
    		   }else if(target > num[left]+num[right]){
    			   left++;
    		   }else{
    			   right--;
    		   }
    	   }
       }
        return res;
    }
}