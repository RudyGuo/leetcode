/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

利用递归动态规划，而且递归的条件要有限制
*/
public class Solution {
	boolean f[];
    public boolean wordBreak(String s, Set<String> dict) {
    	f = new boolean[s.length()];
    	wordBreak(s,dict,0);
    	return f[s.length()-1];
    }
    
    private void wordBreak(String s, Set<String> dict,int index){
    	if(index>=s.length()) return;
    	for(int i=index;i<s.length();i++){
    		if(dict.contains(s.substring(index,i+1))&&f[i]==false){
    			f[i] = true;
    			wordBreak(s,dict,i+1);
    		}
    	}
    }
}

//参考九章算法，提取出set里字符串的最长距离，可以进一步减小算法
public class Solution {
	boolean f[];
	int maxLen = Integer.MIN_VALUE;

    public boolean wordBreak(String s, Set<String> dict) {
    	f = new boolean[s.length()];
    	maxLength(dict);
    	wordBreak(s,dict,0);
    	return f[s.length()-1];
    }
    
    private void wordBreak(String s, Set<String> dict,int index){
    	if(index>=s.length()) return;
    	for(int i=index;i<maxLen+index;i++){
    		if(i<s.length()&&dict.contains(s.substring(index,i+1))&&f[i]==false){
    			f[i] = true;
    			wordBreak(s,dict,i+1);
    		}
    	}
    }
    
    private void maxLength(Set<String> dict){
    	Iterator<String> it = dict.iterator();
    	while(it.hasNext()){
    		maxLen = Math.max(maxLen, it.next().length());
    	}
    }
}
