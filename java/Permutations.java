/* Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
 

public class Solution {
	public List<List<Integer>> permute(int[] num) {
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		List<List<Integer>> lin = new ArrayList<>();
		if (num.length == 0) {
			res.add(list);
			return res;
		}
		int[] num2 = Arrays.copyOfRange(num, 0, num.length - 1);
		lin = permute(num2);
		for (int i = 0; i < lin.size(); i++) {
			list = lin.get(i);
			for (int j = 0; j <= list.size(); j++) {
				List<Integer> linadd = new ArrayList<>(list);
				linadd.add(j, num[num.length - 1]);
				res.add(linadd);
			}
		}
		return res;
	}
}