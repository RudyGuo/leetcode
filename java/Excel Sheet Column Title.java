/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.
*/
public class Solution {  
    public String convertToTitle(int n) {  
        StringBuilder sb = new StringBuilder();  
        while (n > 0) {  
            int apd = n % 26;  
            char c;  
            if (apd == 0) {  
                c = 'Z';  
                n = n / 26 - 1;  
            } else {  
                c = (char) (apd + 'A' - 1);  
                n = n / 26;  
            }  
            sb.append(c);  
        }  
        return sb.reverse().toString();  
    }  
}  
