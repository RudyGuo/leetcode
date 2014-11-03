/*Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
	public List<List<Integer>> subsets(int[] S) {
	    Arrays.sort(S);
	    return help(S);
	}
	
	private List<List<Integer>> help(int[] S){
		if (S.length == 0) {
			List<List<Integer>> lin = new ArrayList<List<Integer>>();
			lin.add(new ArrayList<Integer>());
			return lin;
		}
		int a[] = Arrays.copyOf(S, S.length - 1);
		List<List<Integer>> lin = help(a);
		List<List<Integer>> res = new ArrayList<>(lin);
		for (int i = 0; i < lin.size(); i++) {
			List<Integer> list = new ArrayList<>(lin.get(i));
			list.add(S[S.length - 1]);
			res.add(list);
		}
		return res;
	}
}

