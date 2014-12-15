/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

先DP找出所有的回文字符串，存储在二维数组f中，然后深搜，使用递归增量法
*/
public class Solution {
	boolean f[][];
	List<List<String>> res = new ArrayList<>();

	public List<List<String>> partition(String s) {
		f = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			f[i][i] = true;
		}
		int maxLen = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				f[i][i + 1] = true;
				maxLen = 2;
			}
		}
		for (int len = 3; len <= s.length(); len++) {
			boolean in = false;
			for (int i = 0; i < s.length() - len + 1; i++) {
				if (s.charAt(i) == s.charAt(i + len-1) && f[i + 1][i + len - 2]) {
					f[i][i + len-1] = true;
					in = true;
				}
			}
			if (in) {
				maxLen = len;
			}
		}
		partition(s, maxLen, 0, new ArrayList<String>());
		return res;
	}

	private void partition(String s, int maxLen, int start, List<String> path) {
		if (start >= s.length()) {
			List<String> lin = new ArrayList<>(path);
			res.add(lin);
			return;
		}

			for (int len = 1; len <= maxLen; len++) {
				if (start + len - 1 > s.length() - 1)
					break;
				if (f[start][start + len - 1]) {
					path.add(s.substring(start, start + len));
					partition(s, maxLen, start + len, path);
					path.remove(path.size() - 1);
				}
			}
	}
}
