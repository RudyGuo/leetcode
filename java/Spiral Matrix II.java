/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/


public class Solution {
	int[][] res;
	int seq = 1;

	public int[][] generateMatrix(int n) {
		res = new int[n][n];
		help(n, 0);
		return res;
	}

	private void help(int n, int step) {
		if (step > n / 2)
			return;
		if (step == n / 2 && n % 2 != 0) {
			res[n / 2][n / 2] = seq++;
			return;
		}
		for (int i = step; i < n - step - 1; i++)res[step][i] = seq++;
		for (int i = step; i < n - step - 1; i++)res[i][n - step - 1] = seq++;
		for (int i = n - step - 1; i > step; i--)res[n - step - 1][i] = seq++;
		for (int i = n - step - 1; i > step; i--)res[i][step] = seq++;
		help(n, ++step);
	}
}