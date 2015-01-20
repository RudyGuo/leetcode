/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

利用一个HashMap存储T中的元素，并记录每个元素的个数，然后利用两个指针，尾指针向后直到子字符串包含全部的T，然后头指针向后直到子字符串不能包含全部的T，记录子字符串的长度
参考：LeetCode题解 戴方勤


*/
public class Solution {  
    public String minWindow(String S, String T) {  
        if(S.length() == 0) return "";  
        Map<Character,Integer> map = new HashMap<>();  
        for(int i=0;i<T.length();i++) {  
            Integer n = map.get(T.charAt(i));  
            map.put(T.charAt(i), n==null?1:n+1);  
        }  
        Map<Character,Integer> lin = new HashMap<>();  
        int minStart = S.length();  
        int width = S.length()+1;;  
        int start = 0;  
        int app = 0;  
        for(int end = 0;end<S.length();end++){  
            char c = S.charAt(end);  
            boolean in = false;  
            if(map.containsKey(c)){  
                Integer num = lin.get(c);  
                lin.put(c, num==null?1:num+1);  
                if(lin.get(c)<=map.get(c)){  
                    app++;  
                }  
            }  
            while(app==T.length()){  
                in = true;  
                char cc = S.charAt(start);  
                if(lin.containsKey(cc)){  
                    lin.put(cc, lin.get(cc)-1);  
                    if(lin.get(cc)<map.get(cc)){  
                        app--;  
                    }  
                }  
                start++;  
            }  
            if(in&&end-start+2<width){  
                minStart = start - 1;  
                width = end-start+2;  
            }  
              
        }  
        if(width == S.length()+1) return "";  
        return S.substring(minStart,minStart+width);  
    }  
}  