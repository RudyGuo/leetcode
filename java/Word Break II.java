/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

先dp找到所有的路径，然后用深搜纪录所有结果。注意是否存在解决方案的判定。*/
public class Solution {
	Integer maxLen = -1;
	boolean prev[][];
	boolean f[];
	List<String> res = new ArrayList<>();
	List<String> path = new ArrayList<>();
    public List<String> wordBreak(String s, Set<String> dict) {
        
    	Iterator<String> it = dict.iterator();
        while(it.hasNext()){
        	maxLen = Math.max(it.next().length(),maxLen);
        }
        prev= new boolean[s.length()][maxLen+1];
        f= new boolean[s.length()+1];
        f[0] = true;
        help(0,s,dict);
        //判断是否存在解，不存在解的话调用genPath()会超时
        if(f[s.length()]!=true)return res;
        genPath(0,s,path,res);
        return res;
        
    }
    
    private  void help(int start,String s, Set<String> dict){
    	for(int i=0;i<s.length();i++){
    		for(int j=i+1;j<=i+maxLen&&j<=s.length();j++){
    			String str = s.substring(i,j);
	    		if(f[i]&&dict.contains(str)){
	    			prev[i][j-i] = true;
	    			f[j] = true;
	    		}
    		}
    	}
    }
    
    private void genPath(int start,String s,List<String> path,List<String> res){
		
    	if(start==s.length()){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<path.size()-1;i++){
				sb.append(path.get(i)+" ");
			}
			sb.append(path.get(path.size()-1));
			res.add(sb.toString());
		}
    	for(int i=start+1;i<=s.length()&&i<=start+maxLen;i++){
    		if(prev[start][i-start]){
    			path.add(s.substring(start,i));
    			genPath(i,s,path,res);
    			path.remove(path.size()-1);
    		}
    	}
    }
}
