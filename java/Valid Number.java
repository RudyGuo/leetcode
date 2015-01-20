/*Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

6e6.5不是数，这里指数不能为小数，但是理论上应该是可以的，  3e3.0也不是数
*/
public class Solution {  
   public boolean isNumber(String s) {  
        String strim=s.trim();  
        if(strim.length()==0) return false;  
        if(strim.charAt(0)=='e'||strim.charAt(strim.length()-1)=='e') return false;  
        String strs[] = strim.split("e");  
        if(strs.length>2) return false;  
        for(int i=0;i<strs.length;i++){  
            String string = strs[i];  
            int spot = 0;  
            int num = 0;  
            if(string.length()==1&&(string.charAt(0)=='+'||string.charAt(0)=='-')) return false;  
            for(int j=0;j<string.length();j++){  
                char c = string.charAt(j);  
                if(c=='.'){  
                    if(i==1) return false;  
                    spot++;  
                }else if(c>'9'||c<'0'){  
                    if(j==0&&(c=='-'||c=='+')) continue;  
                    return false;  
                }else{   
                    num++;  
                }  
            }  
            if(num==0||spot>1) return false;  
            String li[] = string.split("\\.");  
            if(li.length==0||li.length>2) return false;  
        }  
        return true;  
    }  
}  