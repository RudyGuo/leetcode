/*Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
public class Solution {  
    public int titleToNumber(String s) {  
        int res = 0;  
        for(int i=s.length()-1;i>=0;i--){  
            res +=(s.charAt(i)-'A'+1)*(int)Math.pow(26,(s.length()-1-i));  
        }  
        return res;  
    }  
}  
