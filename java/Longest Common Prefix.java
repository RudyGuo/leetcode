// Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
        	return "";
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        for(int i = 0;i<strs[0].length();i++){
        	boolean flag = true;
        	String s = strs[0].substring(i,i+1);
        	for(int j = 1;j<strs.length;j++){
        		if(!s.equals(strs[j].substring(i,i+1))) flag = false;
        	}
        	if(flag){
        		sb.append(s);
        	}else{
        		break;
        	}
        }
        return sb.toString();
    }
}