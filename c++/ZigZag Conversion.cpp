/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
class Solution {
public:
    string convert(string s, int numRows) {
    	if(numRows<=1||s.size()<=1) return s;
    	string res;
    	for(int i=0;i<numRows;i++){
    		if(i==0||i==numRows-1){
    			for(int c =i;c<s.length();c+=2*numRows-2){
    				res += s[c];
    			}
    		}else{
    			bool cg = true;
    			for(int c=i;c<s.length();){
    				res +=s[c];
    				if(cg){
    					c += 2*(numRows-i-1);
    				}else{
    					c += 2*i;
    				}
    				cg =!cg;
    			}
    		}
    	}
    	return res;
    }
};