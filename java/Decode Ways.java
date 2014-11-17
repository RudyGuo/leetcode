/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

迭代较简单，递归超时
*/
public class Solution {
	public int numDecodings(String s) {
		int len = s.length();
		if(len == 0) return 0;
		int prev = 1;
		int cur = s.charAt(0)>'0'?1:0;
		if(cur == 0) return 0;
		for(int i=1;i<len;i++){
			int temp = cur;
			int comp = Integer.parseInt(s.substring(i-1,i+1));
			if(s.charAt(i)=='0'){
				char c = s.charAt(i-1);
				if(c=='1'||c=='2'){
				    cur = prev;
					prev = temp;
					continue;
				}else{
					return 0;
				}
			}else if(comp<10||comp>26) {
				prev = temp;
				continue;
			}
			cur += prev;
			prev = temp;
		}
		return cur;
	}
}
