// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
    // For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    // A solution set is:
    // (-1,  0, 0, 1)
    // (-2, -1, 1, 2)
    // (-2,  0, 0, 2)
	
	
public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4) {
			return res;
		}
		Arrays.sort(num);
		for (int j = 0; j < num.length - 3; j++) {
			int target1 =  target - num[j];
			for (int i = j+1; i < num.length - 2; i++) {
				int target2 = target1-num[i];
				int left = i + 1;
				int right = num.length - 1;
				while (left < right) {
					if (target2 == num[left] + num[right]) {
						List<Integer> lists = new ArrayList<Integer>();
						lists.add(num[j]);
						lists.add(num[i]);
						lists.add(num[left]);
						lists.add(num[right]);
						if (res.isEmpty() || !res.contains(lists)) {
							res.add(lists);
						}
						left++;
						right--;
					} else if (target2 > num[left] + num[right]) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return res;
	}
}