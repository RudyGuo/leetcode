/* Given a digit string, return all possible letter combinations that the number could represent.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
递归，深度优先搜索 */

public List<String> letterCombinations(String digits) {
	List<String> res = new ArrayList<String>();
	String strs[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
			"tuv", "wxyz" };
	if (digits == null || digits.length() == 0) {
		res.add("");
		return res;
	}
	if (digits.length() == 1) {
		int k = Integer.parseInt(digits);
		if (k < 2) {
			res.add("");
			return res;
		}
		String s = strs[k];
		for (int i = 0; i < s.length(); i++) {
			res.add(s.charAt(i) + "");
		}
		return res;
	}

	List<String> temp = letterCombinations(digits.substring(1));
	String str = strs[Integer.parseInt(digits.substring(0, 1))];
	if (str == "") {
		return temp;
	}
	for (int i = 0; i < str.length(); i++) {
		for (int j = 0; j < temp.size(); j++) {
			res.add(str.charAt(i) + temp.get(j));
		}
	}
	return res;
}