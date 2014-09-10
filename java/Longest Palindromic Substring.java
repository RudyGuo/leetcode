// Given a string S, find the longest palindromic substring in S. 
// You may assume that the maximum length of S is 1000, and there
// exists one unique longest palindromic substring.
// 动态规划 时间：O(n^2)  空间： O（n^2）

public class Solution {  
    public String longestPalindrome(String s) {  
        int begin = 0;  
        int maxLength = 1;  
        boolean  table[][] = new boolean [s.length()][s.length()];  
        for(int i = 0;i <s.length();i++){  
                table [i][i] = true;  
        }  
          
        for(int i = 0;i<s.length()-1;i++){  
            if(s.charAt(i)==s.charAt(i+1)){  
                table[i][i+1] = true;  
                begin = i;  
                maxLength = 2;  
            }  
        }  
          
        for(int len = 3;len <= s.length();len++){  
            for(int i = 0;i<s.length()-len+1;i++){  
                int j= i+len-1;  
                if(s.charAt(i)==s.charAt(j)&&table[i+1][j-1]){  
                    table[i][j] = true;  
                    begin = i;  
                    maxLength = len;  
                }  
            }  
        }  
          
        return s.substring(begin, begin+maxLength);          
    }  
}  