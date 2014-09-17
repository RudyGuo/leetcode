/* The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. */


public class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	int k = 0;
        	for(int j=i+1;j<s.length();j++){
        		if(c==s.charAt(j)){
        			k++;
        		}else{
        			break;
        		}
        	}
        	i=i+k;
        	if(k==0){
        		sb.append("1"+Character.toString(c));
        	}
        	else{
        		sb.append(Integer.toString(k+1)+Character.toString(c));
        	}
        }
        return sb.toString();
    }
}