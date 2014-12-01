/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<>();
    	for(int i=0;i<rowIndex+1;i++){
    		for(int j=i-1;j>0;j--){
    			int element = list.get(j)+list.get(j-1);
    			list.set(j, element);
    		}
    		list.add(1);
    	}
    	return list;
    }
}
