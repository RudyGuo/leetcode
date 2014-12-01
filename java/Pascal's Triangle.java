/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
迭代 非递归版本
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(numRows<=0) return res;
    	List<Integer> lin = new ArrayList<>();
    	lin.add(1);
    	res.add(lin);
    	if(numRows==1) return res; 
        for(int i=0;i<numRows-1;i++){
        	List<Integer> list = new ArrayList<>();
        	List<Integer> pre = res.get(i);
        	list.add(1);
        	for(int j=0;j<pre.size()-1;j++){
        		list.add(pre.get(j)+pre.get(j+1));
        	}
        	list.add(1);
        	res.add(list);
        }
        return res;
    }
}
}
//递归版本
public class Solution {
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
    	if(numRows<=0) return res;
    	helpGenerate(numRows);
    	return res;
    }
    
    private List<Integer> helpGenerate(int numRows){
    	if(numRows == 1){
    		List<Integer> list = new ArrayList<>();
    		list.add(1);
    		res.add(list);
    		return list;
    	}
    	List<Integer> pre = helpGenerate(numRows-1);
    	List<Integer> list = new ArrayList<>();
    	list.add(1);
    	for(int i=0;i<pre.size()-1;i++){
    		list.add(pre.get(i)+pre.get(i+1));
    	}
    	list.add(1);
    	res.add(list);
    	return list;
    }
}



