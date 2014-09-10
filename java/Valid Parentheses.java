// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
    	if(s==null){
    		return false;
    	}
    	Stack<Character> stack = new Stack<Character>();
    	for(int i = 0;i<s.length();i++){
    		if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
    			stack.push(s.charAt(i));
    			continue;
    		}
    		switch(s.charAt(i)){
    			case ')':
    			if(stack.isEmpty()||stack.pop()!='('){
    				return false;
    			} break;
    			case ']':
    			if(stack.isEmpty()||stack.pop()!='['){
    				return false;
    			} break;
    			case '}':
    			if(stack.isEmpty()||stack.pop()!='{'){
    				return false;
    			} break;
    		}
    	}
    	if(stack.isEmpty()){
    		return true;
    	}else{
    		return false;
    	}
    }
}