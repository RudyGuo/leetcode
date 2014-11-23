/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
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
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return help(root.left,root.right);
	}

	private boolean help(TreeNode left, TreeNode right) {
		if (left == null || right == null){
			if(left==null&&right==null) 
				return true;
			else 
				return false;
		}
		if (left.left == null && left.right == null && left.val == right.val
				&& right.left == null && right.right == null)
			return true;
		
		if(help(left.left,right.right)&&help(left.right,right.left)&&left.val==right.val){
			return true;
		}else{
			return false;
		}
	}
}


