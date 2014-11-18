/*Given a collection of integers that might contain duplicates, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
递归+增量构造法
*/
public class Solution {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	Arrays.sort(num);
        help(num,0);
        return res;
    }

    private  void help(int[]num,int start){
    	if(!res.contains(list)){
    		List<Integer> lin = new ArrayList<Integer>(list);
    	    res.add(lin);
    	}
    	for(int i=start;i<num.length;i++){
    		list.add(num[i]);
    		help(num,i+1);
    		list.remove(Integer.valueOf((num[i])));
    	}
    }
}



