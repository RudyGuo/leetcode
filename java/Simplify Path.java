/*Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".*/

public class Solution {
    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<>(); 
        for(int i=0;i<path.length();){
        	int j = path.indexOf("/",i);
        	if(j==-1){
        		String s = path.substring(i,path.length());
        		if(!s.equals(".")&&!s.equals("..")){
        			stack.push(s);
        		}
        		if(s.equals("..")&&!stack.isEmpty()) stack.pop();
        		break;
        	}
        	if(i==j){
        		i++;
        		continue;
        	}
        	String str = path.substring(i, j);
        	if(!str.equals(".")){
        		if(str.equals("..")){
        			if(!stack.isEmpty()) stack.pop();
        		}else{
        			stack.push(str);
        		}
        	}
        	i=j;
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.insert(0, "/"+stack.pop());
        }
        return sb.toString();
    }
}




