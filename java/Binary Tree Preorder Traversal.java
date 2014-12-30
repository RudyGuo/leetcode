/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?


只要是递归就能用栈来还原递归过程*/
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
	List<Integer> res = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return new ArrayList<Integer>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tn = stack.pop();
			res.add(tn.val);
			if(tn.right!=null){
				stack.push(tn.right);
			}
			if(tn.left!=null){
				stack.push(tn.left);
			}
		}
		return res;
	}
}
