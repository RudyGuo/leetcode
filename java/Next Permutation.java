/* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1 */

public class Solution {
	public void nextPermutation(int[] num) {
		int len = num.length;
		int k = 0;
		for (int i = len - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				k = i;
				break;
			}
		}
		if (k == 0) {
			Arrays.sort(num);
			return;
		}
		for (int i = len - 1; i >= k; i--) {
			if (num[k - 1] < num[i]) {
				num[k - 1] = num[k - 1] ^ num[i];
				num[i] = num[k - 1] ^ num[i];
				num[k - 1] = num[k - 1] ^ num[i];
				break;
			}
		}
		Arrays.sort(num, k, len);
		return;
	}
}