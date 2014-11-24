/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
bfs+递归 思路基本同   Binary Tree Level Order Traversal
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) return res;
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		levelOrder(list, true);
		return res;
	}

	private void levelOrder(List<TreeNode> list, boolean boo) {
		if (list.size() == 0)
			return;
		List<TreeNode> tn = new ArrayList<TreeNode>();
		List<Integer> it = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			TreeNode treeNode = list.get(i);
			if(boo){
			    it.add(list.get(i).val);
			}else{
			    it.add(list.get(list.size()-i-1).val);
			}
			
			if (treeNode.left != null) {
				tn.add(list.get(i).left);
			}
			if (treeNode.right != null) {
				tn.add(list.get(i).right);
			}
		}
		res.add(it);
		levelOrder(tn, !boo);
	}
}
