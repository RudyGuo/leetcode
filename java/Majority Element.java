/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

存入HashMap然后遍历
*/
public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<num.length;i++){
        	if(!map.containsKey(num[i])){
        		map.put(num[i], 1);
        	}else{
        		map.put(num[i], map.get(num[i])+1);
        	}
        }
        
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
        	int val = it.next();
        	if(map.get(val)>num.length/2){
        		return val;
        	}
        }
        return -1;
    }
}
