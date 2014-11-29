/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*
Tree  dfs
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
	int md = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
    	if(root==null) return 0;
    	minDepth(root,1);
    	return md;
    }
    
    private void minDepth(TreeNode root,int depth){
        if(root.left==null&&root.right==null) {
        	md = Math.min(md, depth);
        	return;
        }
        if(root.left!=null){
        	minDepth(root.left,depth+1);
        }
        if(root.right!=null){
        	minDepth(root.right,depth+1);
        }
    }