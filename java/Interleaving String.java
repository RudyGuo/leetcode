/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

二维动态规划 参考LeetCode题解 戴方勤 
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()==0&&s2.length()==0&&s3.length()==0) return true;
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean f[][] = new boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length();i++){
        	f[i+1][0] = (s1.charAt(i)==s3.charAt(i));
        }
        
        for(int i=0;i<s2.length();i++){
        	f[0][i+1] = (s2.charAt(i)==s3.charAt(i));
        }
        
        for(int i=0;i<s1.length();i++){
        	for(int j=0;j<s2.length();j++){
        		f[i+1][j+1] = ((s1.charAt(i)==s3.charAt(i+j+1))&&f[i][j+1])||
        				((s2.charAt(j)==s3.charAt(i+j+1))&&f[i+1][j]);
        	}
        }
        return f[s1.length()][s2.length()];
    }
}
