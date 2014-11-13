/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


参照格雷码
*/
public class Solution {
    public List<Integer> grayCode(int n) {
    	List<Integer> list = new ArrayList<>();
    	List<String> str = help(n);
    	for(int i=0;i<str.size();i++){
    		list.add(Integer.valueOf(str.get(i), 2));
    	}
    	return list;
    }
    
    private List<String> help(int n){
    	List<String> list = new ArrayList<>();
    	if(n==0) {
    		list.add("0");
    		return list;
    	}
    	if(n==1){
    		list.add("0");
    		list.add("1");
    		return list;
    	}
    	List<String> lin = help(n-1);
    	List<String> res = new ArrayList<>();
    	for(int i=0;i<lin.size();i++){
    		String str = "0"+lin.get(i);
    		res.add(str);
    	}
    	for(int i=lin.size()-1;i>=0;i--){
    		String str = "1"+lin.get(i);
    		res.add(str);
    	}
        return res;
    }
}
