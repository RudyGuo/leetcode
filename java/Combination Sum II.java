/* Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6]  */


public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			if(!res.contains(lis))  res.add(lis);
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			list.add(candidates[i]);
			comSum(candidates, res, list, target - candidates[i], i+1);
			list.remove(Integer.valueOf(candidates[i]));
		}

	}
}