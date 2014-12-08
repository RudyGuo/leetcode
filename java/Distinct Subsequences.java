/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

动态规划法：设f[ i ][ j ] 表示 T[ 0 j ]在字符串s[ 0 i ]的出现个数，
如果S[ i ] == T[ j ]  那么f[i][j] = f[i - 1][j] + f[i - 1][j - 1]
反之f[i][j] = f[i - 1][j]
要注意初始化
*/
public class Solution {
	public int numDistinct(String S,String T) {
		if(S.length()<1||T.length()<1||S.length()<T.length()) return 0;
		int f[][] = new int[S.length()][T.length()];
		int in = 0;
		for(int i=0;i<S.length();i++){
			if(S.charAt(i)==T.charAt(0)) in++;
			f[i][0] = in;
		}
		for(int j=1;j<T.length();j++){
			for(int i=1;i<S.length();i++){
				if(S.charAt(i)==T.charAt(j)){
					f[i][j] = f[i-1][j]+f[i-1][j-1];
				}else{
					f[i][j] = f[i-1][j];
				}
			}
		}
		return f[S.length()-1][T.length()-1];
	}
}



