/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/

public class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int res = 0;
        if(length == 0) return res;
        for(int i = length-1;i>=0;i--){
        	if(s.charAt(i)!=' '){
        		for(int j=i;j>=0;j--){
        			if(s.charAt(j)!=' '){
        				res++;
        			}else{
        				break;
        			}
        		}
        		break;
        	}
        }
        return res;
    }
}