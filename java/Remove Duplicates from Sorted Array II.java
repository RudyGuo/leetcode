/* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].*/

public class Solution {
    public int removeDuplicates(int[] A) {
    	List<Integer> list = new ArrayList<Integer>();
    	int comp = Integer.MAX_VALUE;
    	int num = 0;
        for(int i=0;i<A.length;i++){
        	if(comp!=A[i]){
        		comp=A[i];
        		num=1;
        		list.add(A[i]);
        	}else{
        		num++;
        		if(num<=2){
        			list.add(A[i]);
        		}
        	}
        }
        for(int i=0;i<list.size();i++){
        	A[i]=list.get(i);
        }
        return list.size();
    }
}