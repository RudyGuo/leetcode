// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
// (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Solution {
    public String convert(String s, int nRows) {
    	if(nRows==1||s.length()<=nRows){
    		return s;
    	}
    	StringBuffer sb=new StringBuffer();
    	for(int i = 0;i<nRows;i++){
    		if(i==0||i==nRows-1){
    			for(int j=0;i+j<s.length();j+=2*(nRows-1)){
    				sb.append(s.charAt(i+j));
    			}
    			continue;
    		}
    		int k=0;
    		for(int j = i;j<s.length();){
    			if(k==0){
    				sb.append(s.charAt(j));
    				k++;
    				continue;
    			}
    			if(k%2!=0){
    				j+=2*(nRows-i-1);
    				if(j>=s.length()) break;
    				sb.append(s.charAt(j));
    				k++;
    			}else{
    				j+=2*i;
    				if(j>=s.length()) break;
    				sb.append(s.charAt(j));
    				k++;
    			}
    		}
    	}
    	return sb.toString();
    }
}