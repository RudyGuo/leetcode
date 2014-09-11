/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array. */


public class Solution {
	public int search(int[] A, int target) {
		int l = 0;
		int r = A.length-1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (A[mid] == target) {
				return mid;
			}

			if (A[mid] >= A[l]) {
				if (A[mid] > target && A[l] <= target) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (A[mid] < target && A[r] >= target) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;

	}
}