/* Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. */


public class Solution {
    public int longestValidParentheses(String s) {
    	if(s==null||s.length()==0){
    		return 0;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	int lastposition = -1;// the last  not match position of ")"
    	int res = 0;
    	for(int i =0;i<s.length();i++){
    		String str = s.substring(i,i+1);
    		if(str.equals("(")){
    			stack.push(i);
    		}else{
    			if(stack.isEmpty()){
    				lastposition = i;
    			}else{
    				stack.pop();
    				if(stack.isEmpty()){
    					res = Math.max(res, i-lastposition);
    				}else{
    					res = Math.max(res, i-stack.peek());//s.peek()== last not match postion of "("
    				}
    			} 
    		}
    	}
        return res;
    }
}