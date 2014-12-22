/*
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3
Return 6.
maxPath记录最大的路径，计算方式是
    	int sum = root.val;
    	if(left>0) sum += left;
    	if(right>0) sum += right;
    	maxPath = Math.max(sum, maxPath);
然后深搜每个节点，该节点返回的是这个节点的值加上较大的左子树或者较大的右子树
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
	int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }
    
    private int dfs(TreeNode root){
    	if(root==null) return 0;
    	int left = dfs(root.left);
    	int right =  dfs(root.right);
    	int sum = root.val;
    	if(left>0) sum += left;
    	if(right>0) sum += right;
    	maxPath = Math.max(sum, maxPath);
    	return Math.max(left, right)>0?root.val+Math.max(left, right):root.val;
    }
}
