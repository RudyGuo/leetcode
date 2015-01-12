/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

sIdx记录在s的位置，pIdx记录在p的位置，match记录在s中查询匹配的开始位置，starIdx记录了上一个*的具体位置，使用回溯的思想。
*/
public class Solution {  
    public boolean isMatch(String s, String p) {  
        int sIdx = 0,pIdx = 0,starIdx = -1,match = 0;  
        while(sIdx<s.length()){  
            if(pIdx<p.length()&&p.charAt(pIdx)=='*'){  
                starIdx = pIdx;  
                match = sIdx;  
                pIdx++;  
            }else if(pIdx<p.length()&&(p.charAt(pIdx)=='?'||p.charAt(pIdx)==s.charAt(sIdx))){  
                sIdx++;  
                pIdx++;  
            }else if(starIdx != -1){  
                pIdx = starIdx+1;  
                sIdx = ++match;  
            }else{  
                return false;  
            }  
        }  
        while(pIdx<p.length()&&p.charAt(pIdx)=='*'){  
            pIdx++;  
        }  
        if(pIdx==p.length()) return true;  
        return false;  
    }  
}  
