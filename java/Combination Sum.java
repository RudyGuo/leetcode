/* Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]  */


public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		comSum(candidates, res, list, target, 0);
		return res;
	}

	private void comSum(int[] candidates, List<List<Integer>> res,
			List<Integer> list, int target, int start) {
		if (target == 0) {
			List<Integer> lis = new ArrayList<>(list);
			res.add(lis);
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			list.add(candidates[i]);
			comSum(candidates, res, list, target - candidates[i], i);
			list.remove(Integer.valueOf(candidates[i]));
		}

	}
}