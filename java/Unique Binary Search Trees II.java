/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();
		if(n==0){
			res.add(null);
		}
		for (int i = 1; i <= n; i++) {
			List<TreeNode> left = generateTrees(1, i - 1);
			List<TreeNode> right = generateTrees(i + 1, n);
			for (int k = 0; k < left.size(); k++) {
				for (int t = 0; t < right.size(); t++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(k);
					root.right = right.get(t);
					res.add(root);
				}
			}
		}
		return res;
	}

	private List<TreeNode> generateTrees(int m, int n) {
		List<TreeNode> res = new ArrayList<>();
		if (m > n) {
			res.add(null);
			return res;
		}
		if (m == n) {
			TreeNode tn = new TreeNode(m);
			res.add(tn);
			return res;
		}
		for (int i = m; i <= n; i++) {
			List<TreeNode> left = generateTrees(m, i - 1);
			List<TreeNode> right = generateTrees(i + 1, n);
			for (int k = 0; k < left.size(); k++) {
				for (int t = 0; t < right.size(); t++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(k);
					root.right = right.get(t);
					res.add(root);
				}
			}
		}
		return res;
	}
}
