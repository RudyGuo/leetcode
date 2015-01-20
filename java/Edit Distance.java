/*Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

动态规划，难点在于状态的初始化

参考：LeetCode题解  戴方勤     (soulmachine@gmail.com)    https://github.com/soulmachine/leetcode


*/
public class Solution {  
    public int minDistance(String word1, String word2) {  
        if(word1.length()==0||word2.length()==0) return Math.abs(word1.length()-word2.length());  
        int f[][] = new int[word1.length()][word2.length()];  
        boolean b2 = false;  
        for(int i=0;i<word2.length();i++){  
            if(word2.charAt(i)==word1.charAt(0)) b2 = true;  
            if(b2){  
                f[0][i] = i;  
            }else{  
                f[0][i] = i+1;  
            }  
        }  
        boolean b1 = false;  
        for(int i=0;i<word1.length();i++){  
            if(word1.charAt(i)==word2.charAt(0)) b1 = true;  
            if(b1){  
                f[i][0] = i;  
            }else{  
                f[i][0] = i+1;  
            }  
        }  
        for(int i=1;i<word1.length();i++){  
            for(int j=1;j<word2.length();j++){  
                //比较位置的字符相同  
                if(word1.charAt(i)==word2.charAt(j)){  
                    f[i][j] = f[i-1][j-1];  
                }else{  
                    int mn = Math.min(f[i-1][j-1]+1, f[i][j-1]+1);  
                    f[i][j] = Math.min(mn, f[i-1][j]+1);  
                }  
            }  
        }  
        return f[word1.length()-1][word2.length()-1];  
    }  
}  